package com.XAHTEPC;

import  org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Document doc = Jsoup.connect("https://yugorsk-five-school.gosuslugi.ru/nasha-shkola/nash-kollektiv/" ).get();
        Elements postTitleElements = doc.getElementsByAttributeValue("class", "object-info");
        postTitleElements.forEach(postTitleElement -> {
                    Elements name_element = postTitleElement.getElementsByAttributeValue("class",
                            "contacts-object-info tpl-text-header3");
                    System.out.println("ФИО: " + name_element.text());
                    Elements work_element = postTitleElement.getElementsByAttributeValue("class",
                            "contacts-object-info contacts-object-info-subname tpl-text-alt-paragraph");
                    System.out.println("Должность: " + work_element.text());
                    Elements subject_element = postTitleElement.getElementsByAttributeValue("class",
                            "contacts-object-info tpl-text-paragraph");
                    if(!subject_element.text().isEmpty())
                        System.out.println("Предметы: " + subject_element.text() + "\n");
                    else
                        System.out.println("\n");
        }
        );
    }
}
