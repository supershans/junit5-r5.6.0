/*
 * Copyright 2015-2020 the original author or authors.
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v2.0 which
 * accompanies this distribution and is available at
 *
 * https://www.eclipse.org/legal/epl-v20.html
 */

package org.junit.api.tools;

import java.io.PrintWriter;

import org.apiguardian.api.API;

/**
 * @since 1.0
 */
class HtmlApiReportWriter extends AbstractApiReportWriter {

	private static final String HTML_HEADER_FORMAT = "\t<tr><th>%s</th><th>%s</th><th>%s</th></tr>%n";
	private static final String HTML_ROW_FORMAT = "\t<tr><td>%s</td><td>%s</td><td>%s</td></tr>%n";

	HtmlApiReportWriter(ApiReport apiReport) {
		super(apiReport);
	}

	@Override
	protected String h1(String header) {
		return "<h1>" + header + "</h1>";
	}

	@Override
	protected String h2(String header) {
		return "<h2>" + header + "</h2>";
	}

	@Override
	protected String code(String element) {
		return "<span class='code'>" + element + "</span>";
	}

	@Override
	protected String italic(String element) {
		return "<em>" + element + "</em>";
	}

	@Override
	protected String paragraph(String element) {
		return "<p>" + element + "</p>";
	}

	@Override
	protected void printDeclarationTableHeader(PrintWriter out) {
		out.println("<table>");
		out.printf(HTML_HEADER_FORMAT, "Package Name", "Type Name", "Since");
	}

	@Override
	protected void printDeclarationTableRow(Class<?> type, PrintWriter out) {
		out.printf(HTML_ROW_FORMAT, //
			code(type.getPackage().getName()), //
			code(type.getSimpleName()) + " " + italic("(" + getKind(type) + ")"), //
			code(type.getAnnotation(API.class).since()) //
		);
	}

	@Override
	protected void printDeclarationTableFooter(PrintWriter out) {
		out.println("</table>");
	}

}
