# Hibernate Project with One-to-Many Unidirectional Relationship

This Hibernate project implements a one-to-many unidirectional relationship between the `Course` and `Review` entities. In this mapping, a course can have multiple reviews, but a review does not have a direct reference to its course. As a result, deleting a course triggers cascading delete operations, automatically deleting its associated reviews.

## Features

- **One-to-Many Unidirectional Relationship**: Implements a one-to-many unidirectional relationship between `Course` and `Review` entities, allowing courses to have multiple reviews.
- **Cascading Delete**: Applies cascading delete operations from the course to its associated reviews, ensuring data integrity and consistency.
- **Efficient Data Management**: Provides efficient management of course-related reviews, allowing for seamless CRUD operations on courses and their reviews.

## Project Structure

The project structure includes the following components:

- `Course` entity: Represents a course with details such as title, description, and associated reviews.
- `Review` entity: Represents a review for a course, containing details such as rating, comment, and reference to the course.
- `Main` class: Contains the main method to demonstrate CRUD operations and unidirectional mappings.

## Usage

To run the Hibernate project with one-to-many unidirectional relationships locally, follow these steps:

1. Clone this repository.
2. Open the project in your preferred IDE.
3. Update the Hibernate configuration file (`hibernate.cfg.xml`) with your database connection details.
4. Run the `Main` class to execute the CRUD operations and observe the behavior of unidirectional mappings with cascading delete.

## Contributing

Contributions are welcome! If you have any suggestions, bug fixes, or feature implementations, please open an issue or submit a pull request.
