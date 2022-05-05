/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  1erDAM
 * Created: 5 May 2022
 */

CREATE DATABASE personas;
USE personas;

CREATE TABLE persona(id INT AUTO_INCREMENT PRIMARY KEY, nombre VARCHAR(15), apellidos VARCHAR(30), DNI VARCHAR(9), telefono VARCHAR(9));

