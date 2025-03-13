package com.miempresa.entidad;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ProductoTest {

	Producto p1;
	
	@BeforeEach
	void setUp() throws Exception {
		p1 = new Producto("Laptop", 250.99);
	}
	
	/*   CONSTRUCTOR   */

	@Test
	@DisplayName("Test sobre contructor que debe de funcionar bien")
	void testConstructorValid() {
		p1 = new Producto("Helado", 5.99);
		String nombreExpected = "Helado";
		double precioExpected = 5.99;
		assertAll(
				() -> assertEquals(nombreExpected, p1.getNombre()),
				() -> assertEquals(precioExpected, p1.getPrecio())
		);
	}
	
	@Test
	@DisplayName("Test sobre contructor que no debe de funcionar bien, precion negativo")
	void testConstructorPrecioNegative() {
		double precio = -5.99;
		assertThrows(IllegalArgumentException.class, () -> new Producto("Helado", -5.99));
	}
	@Test
	@DisplayName("Test sobre contructor que debe de funcionar bien, precion 0")
	void testConstructorPrecio0() {
		assertDoesNotThrow(() -> new Producto("Helado", 0));
	}
	
	
	/*  GETTER  */
	
	@Test
	@DisplayName("Test sobre getter que debe de devolver perfectamente el nombre")
	void testGetterNombre() {
		assertEquals("Laptop", p1.getNombre());
	}
	
	@Test
	@DisplayName("Test sobre getter que debe de devolver perfectamente el precio")
	void testGetterPrecio() {
		assertEquals(250.99, p1.getPrecio());
	}
	
	/* SETTER  */
	
	@Test
	@DisplayName("Test sobre seter que debe de poner el nombre como argumento al nombre del producto")
	void testSetterNombreValid() {
		p1.setNombre("Helado");
		assertEquals("Helado", p1.getNombre());
	}
	
	@Test
	@DisplayName("Test sobre setter que debe poner el precio como argumeto al precio del producto")
	void testSetterPrecioValid() {
		p1.setPrecio(40);
		assertEquals(40, p1.getPrecio());
	}
	
	@Test
	@DisplayName("Test sobre setter que no debe poner el precio como argumeto al precio del producto, precio negativo")
	void testSetterPrecioNegativo() {
		assertThrows(IllegalArgumentException.class, () -> p1.setPrecio(-30));
	}
	
}
