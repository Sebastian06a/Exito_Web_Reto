#language: es
  @ExitoTest
  Característica: Validación de menús y submenús del Éxito

  Esquema del escenario: Navegación por categorías y subcategorías
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
    Y deberia verse el <resultado_esperado>
    Ejemplos:
      | categoria    | subcategoria   | resultado_esperado                   |
      | Dormitorio   | Cabeceras      | la página de productos de Cabeceras  |
      #| Dormitorior  | Base camas     | la página de productos de Base camas |
      #| Dormitoriooi | Mesas de noche | la página de productos de Mesas      |

