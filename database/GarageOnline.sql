/*
    GarageOnline.sql
    SQL Server schema + sample data for the Garage Online JSP/Servlet project.

    WARNING:
    - This script drops and recreates the GarageOnline database.
    - Run it in SQL Server Management Studio or with sqlcmd using an account
      that can create databases.

    App connection currently expects:
      databaseName=GarageOnline
      userID=sa
      password=123
*/

USE master;
GO

IF DB_ID(N'GarageOnline') IS NOT NULL
BEGIN
    ALTER DATABASE GarageOnline SET SINGLE_USER WITH ROLLBACK IMMEDIATE;
    DROP DATABASE GarageOnline;
END
GO

CREATE DATABASE GarageOnline;
GO

USE GarageOnline;
GO

CREATE TABLE dbo.Roles (
    id INT NOT NULL PRIMARY KEY,
    name NVARCHAR(50) NOT NULL UNIQUE
);
GO

CREATE TABLE dbo.Categories (
    id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
    name NVARCHAR(100) NOT NULL UNIQUE
);
GO

CREATE TABLE dbo.Vehicles (
    id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
    name NVARCHAR(100) NOT NULL UNIQUE
);
GO

CREATE TABLE dbo.Statuses (
    id INT NOT NULL PRIMARY KEY,
    name NVARCHAR(50) NOT NULL UNIQUE
);
GO

CREATE TABLE dbo.Users (
    id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
    name NVARCHAR(100) NOT NULL,
    phone VARCHAR(20) NOT NULL,
    password NVARCHAR(255) NOT NULL,
    role_id INT NOT NULL,
    balance DECIMAL(18,2) NOT NULL CONSTRAINT DF_Users_balance DEFAULT (0),
    created_at DATETIME2(0) NOT NULL CONSTRAINT DF_Users_created_at DEFAULT (SYSDATETIME()),
    CONSTRAINT UQ_Users_name UNIQUE (name),
    CONSTRAINT UQ_Users_phone UNIQUE (phone),
    CONSTRAINT FK_Users_Roles FOREIGN KEY (role_id) REFERENCES dbo.Roles(id),
    CONSTRAINT CK_Users_balance_nonnegative CHECK (balance >= 0)
);
GO

CREATE TABLE dbo.Services (
    id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
    name NVARCHAR(150) NOT NULL,
    price DECIMAL(18,2) NOT NULL,
    description NVARCHAR(1000) NULL,
    img NVARCHAR(255) NULL,
    category_id INT NOT NULL,
    created_at DATETIME2(0) NOT NULL CONSTRAINT DF_Services_created_at DEFAULT (SYSDATETIME()),
    CONSTRAINT FK_Services_Categories FOREIGN KEY (category_id) REFERENCES dbo.Categories(id),
    CONSTRAINT CK_Services_price_nonnegative CHECK (price >= 0)
);
GO

CREATE TABLE dbo.Bookings (
    id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
    user_id INT NOT NULL,
    service_id INT NOT NULL,
    vehicle_id INT NOT NULL,
    problem_description NVARCHAR(1000) NOT NULL,
    booking_date DATETIME NOT NULL CONSTRAINT DF_Bookings_booking_date DEFAULT (GETDATE()),
    status_id INT NOT NULL CONSTRAINT DF_Bookings_status_id DEFAULT (1),
    total_price DECIMAL(18,2) NOT NULL CONSTRAINT DF_Bookings_total_price DEFAULT (0),
    CONSTRAINT FK_Bookings_Users FOREIGN KEY (user_id) REFERENCES dbo.Users(id),
    CONSTRAINT FK_Bookings_Services FOREIGN KEY (service_id) REFERENCES dbo.Services(id),
    CONSTRAINT FK_Bookings_Vehicles FOREIGN KEY (vehicle_id) REFERENCES dbo.Vehicles(id),
    CONSTRAINT FK_Bookings_Statuses FOREIGN KEY (status_id) REFERENCES dbo.Statuses(id),
    CONSTRAINT CK_Bookings_total_price_nonnegative CHECK (total_price >= 0)
);
GO

CREATE INDEX IX_Users_role_id ON dbo.Users(role_id);
CREATE INDEX IX_Services_category_id ON dbo.Services(category_id);
CREATE INDEX IX_Bookings_user_id ON dbo.Bookings(user_id);
CREATE INDEX IX_Bookings_service_id ON dbo.Bookings(service_id);
CREATE INDEX IX_Bookings_vehicle_id ON dbo.Bookings(vehicle_id);
CREATE INDEX IX_Bookings_status_id ON dbo.Bookings(status_id);
CREATE INDEX IX_Bookings_booking_date ON dbo.Bookings(booking_date DESC);
GO

/*
    Compatibility views for legacy code in BookingDAO dashboard methods.
    Most DAO methods use plural table names, but a few dashboard queries use:
      Service, Vehicle, Status
*/
CREATE VIEW dbo.Service AS
SELECT id, name, price, description, img, category_id, created_at
FROM dbo.Services;
GO

CREATE VIEW dbo.Vehicle AS
SELECT id, name
FROM dbo.Vehicles;
GO

CREATE VIEW dbo.Status AS
SELECT id, name
FROM dbo.Statuses;
GO

INSERT INTO dbo.Roles (id, name) VALUES
(1, N'admin'),
(2, N'user');
GO

INSERT INTO dbo.Statuses (id, name) VALUES
(1, N'Pending'),
(2, N'Confirmed'),
(3, N'Repairing'),
(4, N'Completed'),
(5, N'Done');
GO

INSERT INTO dbo.Categories (name) VALUES
(N'Bao duong'),
(N'Sua chua'),
(N'Ve sinh'),
(N'Khan cap');
GO

INSERT INTO dbo.Vehicles (name) VALUES
(N'Honda Wave'),
(N'Honda Vision'),
(N'Yamaha Exciter'),
(N'Honda Air Blade'),
(N'Yamaha Sirius'),
(N'Xe tay ga'),
(N'Xe so'),
(N'Xe con tay');
GO

INSERT INTO dbo.Services (name, price, description, img, category_id) VALUES
(N'Thay dau nhot', 120000,
 N'Thay dau nhot dinh ky giup dong co van hanh em, giam hao mon va tiet kiem nhien lieu.',
 N'static/img/rooms/1.png', 1),
(N'Bao duong tong quat', 350000,
 N'Kiem tra phanh, lop, den, bugi, loc gio va cac hang muc co ban truoc khi xe gap loi lon.',
 N'static/img/rooms/2.png', 1),
(N'Kiem tra va sua phanh', 250000,
 N'Kiem tra bo thang, thay ma phanh khi can va can chinh de dam bao an toan khi van hanh.',
 N'static/img/rooms/3.png', 2),
(N'Sua he thong dien', 300000,
 N'Kiem tra acquy, day dien, den, coi, de may va cac loi dien thuong gap.',
 N'static/img/rooms/4.png', 2),
(N'Rua xe va ve sinh khoang may', 90000,
 N'Lam sach xe, ve sinh cac khu vuc bam bui dau mo va giu xe trong tinh trang gon gang.',
 N'static/img/rooms/4_1.png', 3),
(N'Cuu ho xe chet may', 500000,
 N'Ho tro khan cap khi xe khong khoi dong, het acquy, thung lop hoac gap su co tren duong.',
 N'static/img/gara/garage online.jpg', 4),
(N'Thay lop xe may', 420000,
 N'Kiem tra tinh trang lop va thay lop moi phu hop voi tung dong xe.',
 N'static/img/rooms/2.png', 2),
(N'Can chinh xich va kiem tra truyen dong', 150000,
 N'Ve sinh, tang xich va kiem tra nhong sen dia de xe van hanh on dinh.',
 N'static/img/rooms/1.png', 1);
GO

INSERT INTO dbo.Users (name, phone, password, role_id, balance) VALUES
(N'admin', '0900000000', N'123', 1, 0),
(N'nguyenvana', '0912345678', N'123', 2, 1500000),
(N'tranthib', '0987654321', N'123', 2, 800000),
(N'phamvanc', '0933333333', N'123', 2, 300000);
GO

INSERT INTO dbo.Bookings
    (user_id, service_id, vehicle_id, problem_description, booking_date, status_id, total_price)
VALUES
(2, 1, 1, N'Xe chay lau chua thay dau, may nong nhanh.', DATEADD(DAY, -7, GETDATE()), 1, 120000),
(2, 3, 2, N'Thang truoc keu va cam giac khong an.', DATEADD(DAY, -5, GETDATE()), 2, 250000),
(3, 5, 3, N'Can rua xe va ve sinh sau chuyen di xa.', DATEADD(DAY, -3, GETDATE()), 4, 90000),
(3, 6, 4, N'Xe khong de duoc vao buoi sang.', DATEADD(DAY, -2, GETDATE()), 3, 500000),
(4, 2, 5, N'Bao duong tong quat truoc khi di du lich.', DATEADD(DAY, -1, GETDATE()), 5, 350000),
(4, 7, 6, N'Lop sau mon, can thay lop moi.', GETDATE(), 1, 420000);
GO

SELECT 'Roles' AS table_name, COUNT(*) AS total_rows FROM dbo.Roles
UNION ALL SELECT 'Categories', COUNT(*) FROM dbo.Categories
UNION ALL SELECT 'Vehicles', COUNT(*) FROM dbo.Vehicles
UNION ALL SELECT 'Statuses', COUNT(*) FROM dbo.Statuses
UNION ALL SELECT 'Users', COUNT(*) FROM dbo.Users
UNION ALL SELECT 'Services', COUNT(*) FROM dbo.Services
UNION ALL SELECT 'Bookings', COUNT(*) FROM dbo.Bookings;
GO

