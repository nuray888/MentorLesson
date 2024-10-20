package com.example.studentmanagmentsystem.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class JsoupService{
    @Scheduled(fixedDelay = 1000)
    public void getArzumbeauty() throws IOException {
        Document doc=Jsoup.connect("https://arzumbeauty.com/").get();

//        System.out.println(doc.body());
        Elements elementsByClass = doc.getElementsByClass("product");
//        System.out.println(elementsByClass.get(0));


        for(Element e:elementsByClass){
     Elements productName= e.getElementsByClass("product-holder__info__title");
     Elements productPrice= e.getElementsByClass("product-holder__info__price__current");
            System.out.println(productName.text()+"\n"+productPrice.text()+"\n*********************");
            String attr = e.getElementsByClass("product-holder").attr("href");
            Document links=Jsoup.connect(attr).get();

            Element element = links.getElementsByClass("product-detail__content__abo" +
                    "ut").get(0);



           System.out.println(attr);
            System.out.println(element.text());

        }

    }


}
