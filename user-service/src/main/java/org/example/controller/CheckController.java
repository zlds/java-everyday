package org.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: hanchaowei
 * @date 2023/4/2
 * @description:
 */

@RestController
@RequestMapping("/check")
public class CheckController {

	@GetMapping("/health")
	public String health() {
		return "UP";
	}
}
