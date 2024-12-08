#language: es
  @ExitoTest
  Característica: Validación de menús y submenús del Éxito

  Esquema del escenario: : Navegación por categorías y subcategorías
    Dado que estoy en el menu de la web
    Cuando ingreso a categorias de los productos
    Y selecciono lo que necesite <categoria>
    Entonces debería ver las siguientes subcategorias
    Y selecciono el numero de paginacion 5
    Y le doy clic al boton de agregar producto
    Y doy clic al botton del carrito
    Y doy clic en el detalle del producto
    Y agrego varias veces el producto que es de mi interes
    Y doy clic al boton de pagar el total
    Y ingresar correo electronico y dar clic en confirmar
    Y llenamos el formulario de ingresa tus datos

    Ejemplos:
    |categoria|
    |Dormitorio|
