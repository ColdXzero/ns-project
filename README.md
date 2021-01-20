Overalkl Description 
    Product Features
Notification system provide an open API to add, edit and delete notification templates which contains the notification content with dynamic fields, recipients, send way, priority, scheduling properties. The recipients are contacts list contains the clients list with their IP addresses, phone numbers and E-mail address also their availability time.
The API also is used to send the notifications and connect to server in order to receive push notifications.
The notification system contains server manager to manage the clients connected through the internet which need to receive push notifications. Also contains notifications manager processes the notifications and do notifications requests.
We provide a website with English interface to manage the system and monitor system events, the admin user can login into the website and control his own notification templates. The sender can use the notification template and send the notifications by call the open API.
To show the multi-platform features of our system we developed three types of applications to receive the notifications. 
The system could send SMS, E-mails and push notifications to the clients also use the social media to send notifications.
Also monitoring notification process provide some useful statistics about clients behavior and which the perfect way and time to use effective notifications.


User Classes and Characteristics

Our application will consist of four main users:
    Super admin
    1. Control system configurations add new send engine and configure the accounts related to E-mail, SMS and push notification sending channel.
    2. Create Admin users which should be reliable and provide them privilege.
    3. Monitor the system logs and show the statistics of our system to predict unusual behavior.
    
    Admin
    1. Create, edit and delete notification templates.
    2. Grant access on its own templates to the senders.
    3. Create groups of receivers.
    
    Sender
     Use the notification templates to send the initialized notification.
    
    Clients
    1. Make add request to join group of receivers.
    2. Initialize his own contact configuration (static IP, Email account, phone number so on).
    3. Receive the notifications and response them.
