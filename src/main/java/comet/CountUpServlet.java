package comet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CountUpServlet", urlPatterns = { "/countUp" })
public class CountUpServlet extends HttpServlet {
	// countUpされる値
	AtomicInteger count = new AtomicInteger(0);
	List<AsyncContext> queue = new ArrayList<>();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		int prev = count.get();
		while (count.get() <= prev) {
		}
		resp.setContentType("application/json");
		resp.getWriter().write("{\"count\":\"" + count.get() + "\"}");
	}

	@Override
	public void init() throws ServletException {
		super.init();
		// 1sごとにcountをインクリメントする
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				count.incrementAndGet();
			}
		};
		timer.schedule(task, 5000, 5000);
	}

}
