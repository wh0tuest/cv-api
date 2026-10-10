package com.oleksandr.cv_api.dto;
import java.util.List;

public record ProjectData(Long id, String title, String description, String githubUrl, List<String> technologies) {}