-- Create the database (if not already created)
CREATE DATABASE IF NOT EXISTS hrs-db CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE hrsdb;

-- Create categories table (optional, for grouping)
CREATE TABLE IF NOT EXISTS categories (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Create products table
CREATE TABLE IF NOT EXISTS products (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    price DECIMAL(10,2) NOT NULL,
    category_id INT,
    FOREIGN KEY (category_id) REFERENCES categories(id)
        ON DELETE SET NULL
        ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Insert sample categories
INSERT INTO categories (name) VALUES
('Paint & Supplies'),
('Tools'),
('Flooring');

-- Insert sample products
INSERT INTO products (name, price, category_id) VALUES
('Paint Bucket', 29.99, 1),
('Hammer', 14.50, 2),
('Tile Cutter', 89.00, 3),
('Grout Sealer', 12.75, 1),
('Level Tool', 19.99, 2);