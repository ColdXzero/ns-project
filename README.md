# Introduction

Technologies enter the human life through all doors, People daily use smartphones, social media and smart equipment in their homes and work. So they will always need to know everything that happens around them. The notifications become more powerful by the time, it inform us about something wrong, remained us to do scheduled work, tell us something new we need-to-know.

Although notifications are in our needs, sometimes it becomes more annoying when it works in a wrong way, the notification system should send the notification in the right time when it is useful, to the right person how needs the notification and through the right way where the notification is acceptable.
Our notification system provides an open API to integrate with multi-platforms to send and receive the notification easily. The notification has template designed by the admin user and contains list of contacts to send them the notification, the template also has dynamic content and could be scheduled for remaindering purpose.
The system consider many features in order to send the notification such as priority of the notification, availability, reliability, escalation and scheduled roasters.
The open API is easy to use when you need to control your templates, modify your contacts information and of course send/receive the notification.
Receiving the notifications could be through mobile app, desktop app, websites, social media and indoor/outdoor intelligent circuits.

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
