package com.auditService.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

import com.auditService.DTO.SeoAuditResult;
import com.auditService.service.SeoAuditService;

class SeoAuditServiceTest {

	private final SeoAuditService service = new SeoAuditService();

	@Test
	void shouldExtractSeoInformation() {

		String html = """
				<html>

				<head>

				<title>Spring Boot</title>

				<meta name="description" content="Learn Spring">

				</head>

				<body>

				<h1>Welcome</h1>

				<img src="a.png">

				<img src="b.png"  alt="Logo">

				</body>

				</html>
				""";

		SeoAuditResult result = service.getSeoAuditResponse(html);

		assertEquals("Spring Boot", result.getTitle());
		assertFalse(result.getTitle() == null);

		assertEquals(1, result.getH1Count());

		assertEquals(2, result.getImages());

		assertEquals(1, result.getImagesWithoutAlt());

	}

	@Test
	void shouldHandleMissingTitle() {

		String html = """
				<html>
				<body>Hello</body>
				</html>
				""";

		SeoAuditResult result = service.getSeoAuditResponse(html);

		assertEquals("", result.getTitle());

		assertEquals(0, result.getTitleLength());
	}

}
