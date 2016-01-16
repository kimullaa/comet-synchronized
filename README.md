# comet-synchronized

同期型でcometを実装するサンプル

* サーバ側
    - CountUpServletのcount変数を5sごとにインクリメントします。

* クライアント側
    - /countUpにブラウザからアクセスすると更新があったタイミングで結果が戻ります。

# 起動方法

* mvn tomcat7:run
