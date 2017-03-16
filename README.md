# SpringBootPlayServer
Rest server
Mongo Download link - https://downloads.mongodb.com/win32/mongodb-win32-x86_64-enterprise-windows-64-3.4.2-signed.msi?_ga=1.195751407.238567664.1489122559

Start MongoDB
mongod --dbpath "C:\codebase\mongoData"

Access mongo db from terminal
mongo.exe

Create database in db
db.runCommand( { create: "dream", capped: true, size: 64 * 1024 } )

Create user in DB
use dream
db.createUser( { user: "dreamUser",
                 pwd: "dream",
                 roles: [ { role: "clusterAdmin", db: "admin" },
                          { role: "readAnyDatabase", db: "admin" },
                          "readWrite"] },
               { w: "majority" , wtimeout: 5000 } )

RoboMongo Client :

https://robomongo.org/download

To run Application :

mvn clean spring-boot:run

