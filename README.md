---

# Java HTTP Client Example Project

This Java project demonstrates how to use the `HttpClient` to make HTTP requests and parse JSON responses. Specifically, it fetches data for the top 250 movies from a mock API and extracts key pieces of information: the title, rank, and IMDb rating of each movie.

## Features

- Fetch data using Java's `HttpClient`.
- Parse JSON responses into Java `List` and `Map`.

## Prerequisites

Before running this project, you need to have the following installed:
- JDK 11 or higher (as `HttpClient` and other related classes are part of the Java standard library starting from Java 11).
- A JSON parsing library (this example assumes a custom `JsonParser` class is used for parsing; you may need to replace it with an actual JSON parsing library like Gson or Jackson).

## Setup

1. **Clone the Repository**

   ```
   git clone <repository-url>
   ```

2. **Add a JSON Parsing Library**

   This project requires a JSON parsing library to run. Ensure you have added a dependency for a library like Gson or Jackson in your project's build configuration (e.g., `pom.xml` for Maven or `build.gradle` for Gradle).

   For Maven, add the following dependency for Gson:
   ```xml
   <dependency>
       <groupId>com.google.code.gson</groupId>
       <artifactId>gson</artifactId>
       <version>2.8.6</version>
   </dependency>
   ```
   For Gradle, add:
   ```groovy
   implementation 'com.google.code.gson:gson:2.8.6'
   ```

3. **Replace the `JsonParser` Usage**

   The `JsonParser` class mentioned in the code is a placeholder for actual JSON parsing logic. Replace its usage with your JSON parsing library of choice.

## Running the Project

To run the project, navigate to the project directory in your terminal and compile the `App.java` file:

```
javac App.java
```

Then, run the compiled class:

```
java App
```

This will fetch and display the top 250 movies' data from the mock API endpoint.

## Example Output

The program will output the title, rank, and IMDb rating of the top 250 movies in the console, similar to the following:

```
Movie Title 1 - Rank 1 - Rating 9.2
Movie Title 2 - Rank 2 - Rating 9.1
...
```

## Contributing

Contributions to this project are welcome! Please fork the repository and submit a pull request with your changes.

## License

This project is open source and available under the [MIT License](LICENSE.md).

---