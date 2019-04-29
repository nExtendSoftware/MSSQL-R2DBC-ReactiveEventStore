CREATE DATABASE EventsDB
SELECT Name from sys.Databases
GO
USE EventsDB
CREATE TABLE Events (id uniqueidentifier, event NVARCHAR(512), level NVARCHAR(512), version NVARCHAR(512), createdate datetime2)
GO
USE EventsDB
SELECT * FROM dbo.Events
GO  