package com.auditService.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import com.auditService.DTO.SeoAuditResult;

@Service
public class SeoAuditService {

	public SeoAuditResult getSeoAuditResponse(String html) {

		Document document = Jsoup.parse(html);

		String title = document.title();

		String description = document.select("meta[name=description]").attr("content");

		String canonical = document.select("link[rel=canonical]").attr("href");

		String robots = document.select("meta[name=robots]").attr("content");

		int h1Count = document.select("h1").size();

		Elements images = document.select("img");

		int imagesWithoutAlt = 0;

		for (Element image : images) {

			if (!image.hasAttr("alt") || image.attr("alt").isBlank()) {

				imagesWithoutAlt++;
			}
		}

		String ogTitle = document.select("meta[property=og:title]").attr("content");

		String ogDescription = document.select("meta[property=og:description]").attr("content");

		return new SeoAuditResult(

				title,

				title.length(),

				description,

				description.length(),

				canonical,

				robots,

				h1Count,

				images.size(),

				imagesWithoutAlt,

				ogTitle,

				ogDescription

		);
	}
}
