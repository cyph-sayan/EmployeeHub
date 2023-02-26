package com.nucleiassignment3.HttpServer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListPageRequest {
  private int pageNumber;
  private int pageSize;
}
