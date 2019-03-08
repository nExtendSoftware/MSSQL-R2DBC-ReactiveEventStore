CREATE DATABASE LoggingDB
SELECT Name from sys.Databases
GO
USE LoggingDB
CREATE TABLE Events (id uniqueidentifier, event NVARCHAR(512), level NVARCHAR(512), version NVARCHAR(512), createdate datetime2)
GO
USE LoggingDB
SELECT * FROM dbo.Events
GO  