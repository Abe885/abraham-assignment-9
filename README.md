
Recipe Collection Manager
Project Overview
This Java-based project focuses on managing a collection of recipes. It involves parsing a recipe.txt file and storing its data in a well-defined Java Collection. Utilizing the Apache Commons CSV library for parsing, this application showcases how to handle and process structured text data in Java.

Features
File Parsing: Ingests data from recipe.txt using Apache Commons CSV.
Data Storage: Utilizes Java Collections to store recipe data efficiently.
POJO Representation: Each recipe is represented as a Recipe object with properties like cooking time, dietary information, and more.
RESTful Endpoints: Provides several API endpoints to filter and retrieve recipe data based on dietary preferences.
REST Endpoints
GET /gluten-free: Returns recipes that are gluten-free.
GET /vegan: Retrieves vegan recipes.
GET /vegan-and-gluten-free: Fetches recipes that are both vegan and gluten-free.
GET /vegetarian: Lists vegetarian recipes.
GET /all-recipes: Displays all recipes without any filtering.
Getting Started
Clone this repository.
Import the project into your IDE.
Ensure Apache Commons CSV is correctly added to the project dependencies.
Run the application to start the server.
Project Structure
RestController: Manages the REST API endpoints.
Service Layer: Handles business logic.
Repository (Optional): A place to store the Collection of Recipe objects.
Configuration Class (Optional): Configures project settings, if necessary.
Technologies Used
Java
Spring Boot
Apache Commons CSV
