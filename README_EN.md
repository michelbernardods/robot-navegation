## Robot Navigation API Documentation

### Overview

#### Java Backend Challenge for Conta Azul Company.

The Robot Navigation API allows you to control a robot in a two-dimensional environment, with the ability to move and rotate. The main goal is to send commands to the robot and obtain its final position.

### Endpoints

#### 1. Send Commands to the Robot

- **URL**: `/api/rest/mars/{commands}`
- **HTTP Method**: POST
- **Description**: This endpoint allows you to send a sequence of commands to control the robot and retrieve its final position.

**Example Request:**

```bash
curl -X POST http://localhost:8080/api/rest/mars/MMRMMRMM
```

**Success Response (Status 200 OK)**:

```json
{
    "x": 2,
    "y": 0,
    "direction": "S"
}
```

**Error Response (Status 400 Bad Request)**:

- If the commands are invalid:

```json
"Invalid Command"
```

- If the final position is outside the boundary (0 to 4 for both `x` and `y` coordinates):

```json
"Invalid Position"
```

### Accepted Commands

- 'L': Rotate the robot 90 degrees to the left.
- 'R': Rotate the robot 90 degrees to the right.
- 'M': Move the robot one unit forward in the current direction.

### Usage Examples

- **Example 1**: Move the robot forward and rotate to the right.

```bash
curl -X POST http://localhost:8080/api/rest/mars/MMRMMRMM
```

- **Example 2**: Move the robot forward multiple times.

```bash
curl -X POST http://localhost:8080/api/rest/mars/MMMMMMMMMMMMMMMMMMMMMMMM
```

- **Example 3**: Move the robot forward twice and then rotate to the left.

```bash
curl -X POST http://localhost:8080/api/rest/mars/MML
```

- **Example 4**: Invalid command.

```bash
curl -X POST http://localhost:8080/api/rest/mars/AAA
```

### Limitations

- The environment is a 5x5 grid, represented by coordinates (0 to 4 for both `x` and `y`).
- Accepted commands are 'L', 'R', and 'M'.
- The robot cannot move outside the grid boundaries; commands that would take it outside the grid are ignored.

### How to Run the Project

To deploy the Robot Navigation service in your environment, follow these steps:

1. **Clone the Repository**: Clone the project repository to your system.

2. **Build and Run**: Use Maven, for example: `mvn clean compile` and `mvn install` to build the project and run it.

3. **Testing**: Use your IDE's testing tool to run the service tests.