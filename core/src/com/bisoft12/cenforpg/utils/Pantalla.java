package com.bisoft12.cenforpg.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.utils.viewport.*;

public class Pantalla {
    //Variables para la generacion del mapa
    private TmxMapLoader MAPLOADER;
    private TiledMap MAP;
    private OrthogonalTiledMapRenderer RENDERER;
    private MapProperties PROP;

    //Variables para la vista del mapa, la camara funcionará como lo que se ve, el viewport como la forma que se ve y el scale para que se vea más bonito en mapas pequeños
    private OrthographicCamera CAMERA;
    private Viewport GAMEVIEW;
    private float SCALE;
/************************************CONSTRUCTORES**********************************************************************************************/
    /*
    * Constructor para los mapas que sean mas pequenos de 800x600 y se quiere se queden en el centro de la pantalla
    *
    * Recibe la direccion del mapa .tmx
    * Ejemplo: ("maps/map/terrainMonster.tmx")
    * */
    public Pantalla(String pMap) {

        this.CAMERA = new OrthographicCamera();
        this.GAMEVIEW = new StretchViewport(Resources.WIDTH, Resources.HEIGHT, this.CAMERA);

        SCALE = Gdx.graphics.getWidth() / 800f;

        this.MAPLOADER = new TmxMapLoader();
        this.MAP = MAPLOADER.load(pMap);
        this.RENDERER = new OrthogonalTiledMapRenderer(this.MAP, SCALE);

        sizeMap();
    }
    /*
    * Constructor para los mapas mas grandes de 800x600
    *
    * Recibe la direccion del mapa .tmx y la posicion X y Y de donde se quiera que se vea inicialmente el mapa
    * Ejemplo ("maps/map/dungeon.tmx", 400, 118)
    * NOTA, para saber la posicion de X y Y se puede ver en Tiled, sino 0,0 es izquierda abajo del mapa, se carga ese punto en el centro del mapa.
    * */
    public Pantalla(String pMap, int pX, int pY) {

        this.CAMERA = new OrthographicCamera();
        this.GAMEVIEW = new StretchViewport(Resources.WIDTH, Resources.HEIGHT, this.CAMERA);

        this.MAPLOADER = new TmxMapLoader();
        this.MAP = MAPLOADER.load(pMap);
        this.RENDERER = new OrthogonalTiledMapRenderer(this.MAP);

        this.CAMERA.position.set(pX, pY, 0);
    }

    /********************************Metodos publicos*************************************************************/
    /*
    * Metodo update, este se encarga del update del mapa.
    *
    * Recibe el delta del update de la pantalla. (Igual es por si lo vamos a usar en un futuro)
    * */
    public void update(float pDelta) {
        // movementCamera();
        this.CAMERA.update();
        this.RENDERER.setView(CAMERA);
        this.RENDERER.render();

    }
    /*
    * Metodo dispose, se encarga de eliminar la info de la memoria
    * */
    public void dispose() {
        //Limpiamos cuando se salga de la pantalla
        this.MAP.dispose();
        this.RENDERER.dispose();
    }
    /*
    * Metodo resize, para que el mapa no se vea diferente a como se ver a pantalla completa o al tamano que se desea.
    *
    * Igual creo que no se va a usar
    * */
    public void resize(int width, int height) {
        this.GAMEVIEW.update(width, height);
    }
    /********************************Metodos privados*********************************************************************/
    /*
    * Metodo para el movimiento de la camara (Para pruebas)
    * */
    private void movementCamera() {
        this.CAMERA.position.x += 1;
        System.out.println(this.CAMERA.position.x);
        System.out.println(this.CAMERA.position.y);
    }
    /*
    * Metodo para cuando el mapa sea más pequeño de 800x600, para que siempre se ponga al centro de la pantalla
    * */
    private void sizeMap() {
        this.PROP = MAP.getProperties();

        int mapWidth = PROP.get("width", Integer.class);
        int mapHeight = PROP.get("height", Integer.class);
        int tilePixelWidth = PROP.get("tilewidth", Integer.class);
        int tilePixelHeight = PROP.get("tileheight", Integer.class);

        int mapPixelWidth = mapWidth * tilePixelWidth;
        int mapPixelHeight = mapHeight * tilePixelHeight;

        //Por si se quiere saber el tamano del mapa
        System.out.println(mapPixelWidth);
        System.out.println(mapPixelHeight);

        this.CAMERA.position.set(mapPixelWidth / 2, mapPixelHeight / 2, 0);
    }


}