
package arbolRojoNegro;

import java.util.LinkedList;
import java.util.List;

/**
 * Implementaci�n de un �rbol binario balanceado por el m�todo rojo-negro.
 * 
 * 
 * @param <T> Tipo de informaci�n almacenada por el �rbol.
 */
public class ArbolRojoNegro<K extends Comparable<K>, T> 
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
	 * Constante para la serializaci�n
	 */
//	private static final long serialVersionUID = 1L;

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------
	
    /**
     * Raiz del �rbol.
     */
    private NodoRojoNegro<K,T> raiz;
    
    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------    

    /**
     * Constructor por defecto.
     * </p>
     * Construye un �rbol vacio.
     */
    public ArbolRojoNegro( )
    {
        raiz = null;
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------      
    
    /*
     * (non-Javadoc)
     * @see uniandes.cupi2.collections.arbol.IArbolOrdenado#insertar(java.lang.Comparable)
     */
    public void insertar( K key, T elem ) 
    {
        // Crear el nuevo nodo y agregarlo como si el arbol fuera un arbol
        // binario normal
        NodoRojoNegro<K,T> nodo = new NodoRojoNegro<K,T>( key, elem );

        NodoRojoNegro<K,T> r2 = null;

        if( raiz == null )
        {
            raiz = nodo;
            raiz.cambiarColor( NodoRojoNegro.NEGRO );
        }
        else
        {
            r2 = raiz.insertar( nodo );
        }

        raiz = r2 != null && r2.darPadre( ) == null ? r2 : raiz;
    }

    /*
     * (non-Javadoc)
     * @see uniandes.cupi2.collections.arbol.IArbolOrdenado#eliminar(java.lang.Comparable)
     */
    public void eliminar( K elem ) 
    {
        if( raiz != null ){
            //throw new ElementoNoExisteException( "El árbol se encuentra vacio" );
        if( raiz.darKey().compareTo( elem ) == 0 && raiz.hijoDerechoHoja( ) && raiz.hijoIzquierdoHoja( ) )
            raiz = null;
        else
        {   if (raiz.darNodo(elem) != null){
            NodoRojoNegro<K,T> r2 = raiz.darNodo( elem ).eliminar( );
            raiz = r2 != null && r2.darPadre( ) == null ? r2 : raiz;}
        }}
    }

    /**
     * Retorna una lista con los elementos del árbol en preorden.
     * 
     * @return Una lista con los elementos del árbol en preorden.
     */
//   

//    /**
//     * Verifica si un elemento existe en el arbol.
//     * 
//     * @param elem Elemento a buscar en el arbol.
//     * @return <code>true</code> si el elemento es encontrado en el arbol o <code>false</code> en caso contrario.
//     */
//    public boolean existe( T elem )
//    {
//        return raiz != null ? raiz.existe( elem ) : false;
//    }

    /*
     * (non-Javadoc)
     * @see uniandes.cupi2.collections.arbol.IArbol#buscar(java.lang.Object)
     */
    public T buscar( K modelo )
    {
        try
        {   
            if (raiz.darNodo(modelo)== null)
                return null; 
            return raiz != null ? raiz.darNodo( modelo ).darElemento( ) : null;
        }
        catch( Exception e )
        {
            return null;
        }
    }

    /**
     * Retorna la raiz del árbol.
     * 
     * @return La raiz del árbol.
     */
    public NodoRojoNegro<K, T> darRaiz( )
    {
        return raiz;
    }

    
    /* (non-Javadoc)
     * @see uniandes.cupi2.collections.arbol.IArbol#darPeso()
     */
    public int darPeso( )
    {
        return raiz == null ? 0 : raiz.darPeso( );
    }

    /* (non-Javadoc)
     * @see uniandes.cupi2.collections.arbol.IArbol#darAltura()
     */
    public int darAltura( )
    {
        return raiz == null ? 0 : raiz.darAltura( );
    }

    /**
     * Retorna el menor elemento del árbol.
     * 
     * @return El menor elemento del árbol o <code>null</code> si el árbol esta vacio.
     */
    public T darMinimo( )
    {
        return raiz == null ? null : raiz.darMenor( ).darElemento( );
    }

    /**
     * Retorna el mayor elemento del árbol.
     * 
     * @return El mayor elemento del árbol o <code>null</code> si el árbol esta vacio.
     */
    public T darMayor( )
    {
        return raiz == null ? null : raiz.darMayor( ).darElemento( );
    }

    
    
    
    public ArbolRojoNegro<K, T> recorrerArbolRango(String inicio, String fin )
    {
    	ArbolRojoNegro<K, T> rango = new ArbolRojoNegro<K, T>( );
        if( raiz != null ) {
    
        }
        raiz.recorrerArbolRango( rango,inicio,fin );

        return rango;
    }
    
    
    public void darPreorden( )
    {
        if( raiz != null )
            raiz.darPreorden(  );
    }
    
    
}