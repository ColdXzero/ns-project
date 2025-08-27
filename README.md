# Notification System (NS)

A comprehensive Java-based notification system that provides a RESTful API for managing and sending notifications across multiple platforms. The system supports SMS, email, web socket, and social media notifications with template management, user roles, and priority-based queuing.

## Table of Contents
- [Features](#features)
- [Project Structure](#project-structure)
- [Requirements](#requirements)
- [Setup Instructions](#setup-instructions)
- [Configuration](#configuration)
- [API Endpoints](#api-endpoints)
- [Usage](#usage)
- [Contributing](#contributing)

## Features

- **Multi-Platform Notifications**: Send notifications via SMS, Email, Web Sockets, and Social Media
- **Template Management**: Create and manage notification templates with dynamic content
- **User Role Management**: Admin and client roles with different privileges
- **Priority Queuing**: Three-tier priority system for notification processing
- **Scheduling & Escalation**: Schedule notifications and escalate through alternative channels
- **Response Analytics**: Track user response patterns to optimize delivery timing
- **Web Interface**: Admin panel for system management
- **RESTful API**: Easy integration with external systems
- **Real-time Notifications**: WebSocket support for instant notifications

## Project Structure

```
ns-project/
├── src/
│   ├── api/                          # RESTful API endpoints
│   │   ├── NotificationAPI.java      # Notification management API
│   │   ├── TemplateAPI.java          # Template management API
│   │   ├── UserAPI.java              # User management API
│   │   └── Test_api.java             # API testing utilities
│   ├── Controller/                   # Business logic controllers
│   │   ├── C_Notification.java       # Notification controller
│   │   ├── C_Template.java           # Template controller
│   │   ├── C_User.java               # User controller
│   │   ├── C_Group.java              # Group management
│   │   └── ...                       # Other controllers
│   ├── model/                        # Data models
│   │   ├── Ns_Notification.java      # Notification entity
│   │   ├── Ns_User.java              # User entity
│   │   ├── NotTemplate.java          # Template entity
│   │   └── ...                       # Other entities
│   ├── DBA/                          # Database access layer
│   │   └── MysqlConnection.java      # MySQL connection manager
│   ├── Notification_Management/      # Core notification logic
│   │   ├── Notification_manage.java  # Notification processing
│   │   ├── Mail.java                 # Email service
│   │   ├── SendSMS.java              # SMS service
│   │   ├── PushNotification.java     # Push notification service
│   │   └── ServerStart.java          # Server initialization
│   ├── UserManagement/               # User management utilities
│   ├── Group_Management/             # Group management utilities
│   ├── Template_management/          # Template management utilities
│   ├── Setting_Management/           # System settings management
│   └── Site/                         # Web interface servlets
│       ├── SignInUser.java           # User authentication
│       ├── SignUpUser.java           # User registration
│       ├── AddTemplate.java          # Template creation
│       └── ...                       # Other servlets
├── WebContent/                       # Web application files
│   ├── *.jsp                         # JSP pages for admin interface
│   ├── css/                          # Stylesheets
│   ├── js/                           # JavaScript files
│   ├── images/                       # Static images
│   ├── META-INF/                     # Metadata
│   └── WEB-INF/
│       └── web.xml                   # Web application configuration
└── README.md
```

## Requirements

### System Requirements
- **Java**: JDK 8 or higher
- **Application Server**: Apache Tomcat 8.5+ or similar Java EE container
- **Database**: MySQL 5.7 or higher
- **Build Tool**: Maven (recommended) or manual dependency management

### Dependencies
- **JAX-RS**: Jersey framework for RESTful web services
- **MySQL Connector**: JDBC driver for MySQL database connectivity
- **Java EE**: Servlet API, JSP support
- **Optional**: JSON processing libraries for API responses

## Setup Instructions

### 1. Database Setup

1. **Install MySQL** and create a new database:
```sql
CREATE DATABASE notificationcenterdb;
```

2. **Configure Database Connection**: Update the connection details in `src/DBA/MysqlConnection.java`:
```java
public static String Connection_string="jdbc:mysql://localhost:3306/notificationcenterdb";
public static String UserName="your_username";
public static String Password="your_password";
```

3. **Create Database Tables**: Execute the SQL scripts to create the required tables for:
   - Users (`ns_user`)
   - Templates (`ns_template`)
   - Notifications (`ns_notification`)
   - Groups, Contacts, Settings, etc.

### 2. Application Server Setup

1. **Install Apache Tomcat** (version 8.5 or higher)

2. **Configure JDBC Driver**: 
   - Download MySQL Connector/J
   - Place `mysql-connector-java-x.x.x.jar` in Tomcat's `lib` directory

3. **Deploy the Application**:
   - Build the project into a WAR file
   - Deploy to Tomcat's `webapps` directory
   - Or use IDE deployment features

### 3. Build and Deployment

#### Option A: Using IDE (Eclipse/IntelliJ)
1. Import the project as a Dynamic Web Project
2. Configure build path with required JAR dependencies
3. Configure server runtime (Tomcat)
4. Right-click project → Run As → Run on Server

#### Option B: Manual Build
1. Compile Java sources: `javac -cp "lib/*" src/**/*.java`
2. Create WAR file with compiled classes and WebContent
3. Deploy WAR to Tomcat webapps directory

### 4. Required JAR Dependencies

Add these JAR files to your build path:
- `jersey-server-2.x.x.jar`
- `jersey-container-servlet-2.x.x.jar`
- `mysql-connector-java-x.x.x.jar`
- `javax.servlet-api-x.x.x.jar`
- Additional Jersey dependencies as needed

## Configuration

### Web Application Configuration
The main configuration is in `WebContent/WEB-INF/web.xml`:
- Servlet mapping for Jersey REST services at `/service/*`
- Welcome file configuration
- Application display name: "Notification System Server"

### Database Configuration
Update connection parameters in `MysqlConnection.java`:
- Database URL
- Username and password
- Connection pool settings (if implemented)

### Notification Services Configuration
Configure external service credentials in respective service classes:
- SMTP settings for email notifications (`Mail.java`)
- SMS gateway credentials (`SendSMS.java`)
- Push notification service keys (`PushNotification.java`)

## API Endpoints

The RESTful API is accessible at `http://localhost:8080/ns-project/service/`

### Notification API (`/templates`)
- `GET /Response/key={Token}&ID={ID}&code={NotCode}` - Process notification response

### Template API
- Template creation and management endpoints

### User API  
- User authentication and management endpoints

*Note: Complete API documentation should be generated from JAX-RS annotations*

## Usage

### 1. Access the Web Interface
Navigate to `http://localhost:8080/ns-project/` to access the admin panel

### 2. Create Admin Account
Use the signup functionality to create an admin user account

### 3. Configure Templates
- Create notification templates with content and contact lists
- Set priority levels and delivery methods
- Configure scheduling and escalation rules

### 4. Send Notifications
- Use the web interface or API endpoints
- Notifications are processed through priority queues
- Monitor delivery status and user responses

### 5. API Integration
Integrate external systems using the RESTful API:
```java
// Example API call to send notification response
GET /service/templates/Response/key=user_token&ID=123&code=ABC123
```

## Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/new-feature`)
3. Commit your changes (`git commit -am 'Add new feature'`)
4. Push to the branch (`git push origin feature/new-feature`)
5. Create a Pull Request

## License

This project is part of a senior project for notification system development.

---

## Technical Documentation
│   └── WEB-INF/
│       └── web.xml                   # Web application configuration
└── README.md
```

### Product

Notification System NS contains a Restful API to control notification template and send the notifications through specific template, also clients’ apps and systems can connect to our server to receive the notifications.

There are two main users the admin who create the template and edit templates details such as content, contact list and other properties. And modify clients privilege who can send the notifications, the second role is for client who can send notification through his granted templates and can update the contacts or disable receiving notifications.

The system can send multi-type notification in different ways (SMS, Email, runtime notifications using web sockets and through social media Ex: Facebook, WhatsApp).
The core system is a service checks the notifications in the sending queue and proceed them with considering the priority of each kind of notification template and its priority and its properties like scheduling, sending way, escalation. It also checks the availability of the receiver upon the data of clients’ response.
Developing Java restful API is useful to integrate with different type of systems. We will develop desktop client application and mobile android application for client or admin role. Web socket techniques also provide runtime notification in easy way.

The website is provided with English interface to control the system by super admin user and monitor the notification process. Also it helps the admin user to control the templates and send the notifications.

### Scope

Due to simple API interface, Notification System serves multi-platforms applications and systems. It will be useful for online desktop, mobile and web applications.
The clients will check the notification that will be sent through E-mails, SMS and on pop-up windows on desktop application or internet browser or mobile application.
The system helps group of clients to receive the notifications when they are available and in the right time.

### Business Goals

**Our business goals are:**
**Make an easy and secure way for companies, restaurants, hotels etc. to inform the clients about new information.
Provide simple API to integrate with systems and apply reliable way to send notifications when there are important info to be sent.
Provide clients desktop/mobile application to be updated with important notifications sent from information provider or NEWS applications.
Provide remainder service for user’s scheduled events.**

Send the right notification to the right person in the right way and right time.

## Literature Review
### Notification System 
Every interaction with multimedia contents in various application domains can be called an Event. Arising from an each Event there is the opportunity to describe what occurred.
The notification system should work with multi-platform systems as we can show in The ENS implemented in “Event Notification System for Multi-platform” that can be used for different kind of multi-platform environment that includes PC, mobile device, and television set. The implementation also can be used for various kind of reporting that includes monitoring of illegal copies, monitoring of performances, marketing information, copyright reports, proof of purchase, license purchase and delivery, network congestion, load balancing, and bandwidth usage and availability.

The event report described in the ENS works as the following, the first peer creates an Event Report Request and send it to the second one, and when the event described in the request is handled on the second peer side the second one sends the event report.

People can now receive custom-made information through smartphones, tablets or wearable devices. However, people often tend to miss vital information, even reminders, in the flood of notifications. The problem of finding convenient moments for need-to-know information should be Investigated. The challenges of context-base notification systems are: selecting fundamental context factors that influence the activity patterns of individual agents; keeping track of these factors in real-time; carefully looking into the monitoring data; and immediately coping with recognized desirable situations. Considering these challenges, there is a mobile framework, smartNoti, that provide a standardized method for finding the recognizable and available moment. By logging the user activity and predicate the right moment.

The importance of notification system can be shown for example in SOA-Based Diseases Notification System that uses SOA-based system to integrate between multi-business layers and inform the patients, health centers and hospitals about exchanges of diseases with fast and easy way that can be consumed by many different systems.

Notification system is useful tool for monitoring application servers, Application servers are usually deployed in clusters consisting of tens nodes. Each node contains own log file and runs on different machine that has its own performance/system logs. but there is challenge that is high load which is proceeded in NotX system by use queue and streaming notifications.

While almost every information system has standard e-mail notifications, the features of SMS notifications or voice notifications (telephone calls via cellular networks) are not very common, but there are many instances, where they could be useful:
Urgent appeal through voice calls about the rescheduling of some event
SMS for dual authentication processes where a confirmation SMS is sent
SMS with any information that the user should have with himself. For example, a registration code for an event
There is of course a downside with using SMS and voice notifications: the price. NS must be configurable so that the user can choose which events are so important to him that he is willing to pay the price for such notifications.**

In industrial building notification system is very important to inform about any issues happened during machines works, sensors creates signals to be proceeded in the control system which checks these properties and create alarm if there is something wrong, here the notifications system should be embedded with control unit to send efficient notification.

Sometimes the notifications should be as fast as possible, here the push notification has its opportunity, the design and implementation of push notification service use a client/ server design pattern with a distributed architecture.

The user interactivities with the notification system make the system knows user normal behavior and learn when and where is the notification effected, in alarming system that work with sensors, Notifications will be generated in the form of blinking light in the room where the situation is detected. If user is aware what is going on, he/she should press twice the nearest light button in order to inform the Notification system that the potential problem is solved and that everything is under control. After that action corresponding timers are reset.

## Web services
### Web Services Overview
Web services technology is changing the Internet augmenting the web capabilities to produce the transactional web. Because Web services are emerging to provide a systematic and extensible framework for application-to-application interaction.

**"Where the current web enables users to connect to applications, the web services architecture enables applications to connect to other applications. Web services is therefore a key technology in enabling business models to move from B2C (Business to Consumer) to B2B (Business to Business)".**

Web services technologies provide a language-neutral, environment-neutral programming model that accelerates application integration inside and outside the enterprise. Application integration through Web services yields flexible loosely coupled business systems.

Because Web services are easily applied as a wrapping technology around existing applications and information technology assets, new solutions can be deployed quickly and recomposed to address new opportunities.

So the web service is an interface that describes a collection of operations and performs a specific task or a set of tasks. These operations are network-accessible through standardized XML messaging. A Web service is described using a standard, formal XML notation, called its service description that provides all of the details necessary to interact with the service, As will be explained in the next paragraph.

We will explain two kinds for web services (SOAP-Based vs. RESTful web services) to know the best way for our approach.

## SOAP-Based Web Service 

The Web services framework is divided into three areas -communication protocols, service descriptions, and service discovery- and specifications are being developed for each. In SOAP-Based web services the specifications in each area: SOAP, WSDL, and UDDI respectively.

We will explain each standard in the next paragraphs and the web services infrastructure that is based on these standards.

## SOAP-Based Web Service Architecture
In fact, the web services infrastructure can be thought of as a distributed digital library for services rather than information. This means that many of the issues must be addressed within a web services context, such as metadata for discovery, authentication and authorization, and business models for accessing intellectual property.

IBM has published its web services architecture, which captures the infrastructure required to support web services in terms of three roles and three operations.
**The three roles are:**
*The service provider,*
*The service requester,*
*The service registry.* 

The objects acted upon are the service and the service description, and the operations performed by the actors on these objects are:
Publish, find, and bind.

In this SOAP-Based web service architecture , the service description is the metadata that describe the service and include sufficient information for a service requestor to access the service it describes service including all of the details necessary to interact with the service, including its interface,  message formats (that detail the operations), transport protocols, and location.

Then the service provider publishes a service description to a service registry and then service requester becomes able to find the service description.

### Notification System based on Restful Web Service
Why we use restful API? It provide an open fast connection between the client layer and the server side, consuming restful API is easy on different platforms where it could be consumed inside web application, desktop application or android app. Many researches and projects that worked in building notifications system agreed that the web service is useful component of notification system.

To proceed the notifications requests we define three notifications queues, each one of them has type of priority where the high priority queue proceeded first by the notification manager.

Notification manager is a service checks the ready notification inserted in notifications queues, and send them according to the notification template, in other hand checks availability of the clients to determine the right time to send by using the response analytic service which define the time when the client is ready to receive an useful notifications, this service works on client response time and try to know the client’s behavior after checking client’s responses.

To the high priority notification, the notification manager check if there is a scheduled roaster contains optional contacts or alternative send way to ensure that the notification could receive successfully. Escalation is optional choice makes the manager try to send the notifications through different ways in case there is no response.

Using SMS and E-mails is powerful in our system, we described the advantages and disadvantages of using SMS channel for notifications. However, E-mails and push notifications may be less cost than the SMS channel, so we use them as main sending way. In the other hand response the E-mail or real time notification is easier than the SMS.

Push notification also helps for runtime notifications when the users should be online and connected to our server.
Avoiding annoying notifications built on some important points: know the client behavior, limit user’s send rate, monitoring the system behavior to prevent any abuse or attacks and apply secure way to initialize new admin account.
