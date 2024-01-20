package com.simple.simplespringboot.controller;

import lombok.Builder;

@Builder
public record UserResource(Long id, String name) {
}
