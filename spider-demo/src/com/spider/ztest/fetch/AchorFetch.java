package com.spider.ztest.fetch;

import java.io.InputStream;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class AchorFetch extends Fetch {

	public AchorFetch(String root, int depth) {
        super(root, depth);
        // TODO Auto-generated constructor stub
    }
 
    public AchorFetch(U root, int depth) {
        super(root, depth);
    }
 
    @Override
    protected void process(InputStream in) throws Exception {
        Document doc = Jsoup.parse(in, "UTF-8", "");
        Elements as = doc.select("a");
        for (Element a : as) {
            String href = a.absUrl("href");
            if (href != null && !"".equals(href)) {
                href = a.attr("href");
                href = this.getHost()
                        + (href.startsWith("/") ? href : "/" + href);
            }
            if (href != null && !"".equals(href)) {
                String line = "[线程：" + this.getRoot().getUrl() + "][总深度:"
                        + this.getDepth() + "][当前深度:"
                        + this.getRoot().getDepth() + "][URL:" + href + "]";
                U u = new U(this.getRoot().getDepth() + 1, href);
                System.out.println(line);
                new Thread(new AchorFetch(u, this.getDepth())).start();
            }
        }
    }
}
