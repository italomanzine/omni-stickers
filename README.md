# Java HTTP Client Example Project

## Overview

This Java project demonstrates how to use the `HttpClient` to make HTTP requests and parse JSON responses. Specifically, it fetches data for the top 250 movies from a mock API and extracts key pieces of information: the title, rank, and IMDb rating of each movie.

## Features

- Utilizes Java's `HttpClient` for making HTTP requests.
- Parses JSON responses into Java `List` and `Map`.

## Prerequisites

Before running this project, you need to have the following installed:
- JDK 11 or higher (as `HttpClient` and other related classes are part of the Java standard library starting from Java 11).
- A JSON parsing library (this example assumes a custom `JsonParser` class is used for parsing; you may need to replace it with an actual JSON parsing library like Gson or Jackson).
