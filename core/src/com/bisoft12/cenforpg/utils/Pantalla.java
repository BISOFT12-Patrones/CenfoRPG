package com.bisoft12.cenforpg.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.viewport.*;
import com.bisoft12.cenforpg.utils.InteractiveObjects.House;

import java.util.ArrayList;

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

    //Para la creacion de 2D Boxes
    private ArrayList<Box2DHelper> BH = new ArrayList<Box2DHelper>();
    private Box2DHelper box2Helper;
    private World world;
    private Box2DDebugRenderer renderBox2dHelper;

    //Para los objetos interactivos
    //Entrar Casa
    boolean house;
    int houseLayer;
    //Entrar Mercader
    boolean merchant;
    int merchantLayer;
    //Para entrar a la ciudad
    boolean city;
    int cityLayer;
    //Para entrar a la dungeon
    boolean dungeon;
    int dungeonLayer;
    //Para entrar a la terrainMonster
    boolean terrain;
    int terrainLayer;
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


        this.world = new World(new Vector2(0, 0), true); //Vector 2 es para la gravedad dentro de los juegos de plataforma, en nuestro caso es 0,0 ya que sino se cae el personaje
        this.box2Helper = new Box2DHelper(world);

        this.renderBox2dHelper = box2Helper.getB2DR();

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


        this.world = new World(new Vector2(0, 0), true); //Vector 2 es para la gravedad dentro de los juegos de plataforma, en nuestro caso es 0,0 ya que sino se cae el personaje
        this.box2Helper = new Box2DHelper(world);
        this.renderBox2dHelper = box2Helper.getB2DR();

        this.CAMERA.position.set(pX, pY, 0);

    }

    public OrthographicCamera getCAMERA() {
        return CAMERA;
    }

    public World getWorld() {
        return world;
    }

    public Box2DDebugRenderer getRenderBox2dHelper() {
        return renderBox2dHelper;
    }

    public void setHouse(boolean pHouse) {
        this.house = pHouse;
    }

    public void setHouseLayer(int pHouseLayer) {
        this.houseLayer = pHouseLayer;
    }

    public void setMerchant(boolean pMerchant) {
        this.merchant = pMerchant;
    }

    public void setMerchantLayer(int pMerchantLayer) {
        this.merchantLayer = pMerchantLayer;
    }

    public void setCity(boolean city) {
        this.city = city;
    }

    public void setCityLayer(int cityLayer) {
        this.cityLayer = cityLayer;
    }

    public void setDungeon(boolean dungeon) {
        this.dungeon = dungeon;
    }

    public void setDungeonLayer(int dungeonLayer) {
        this.dungeonLayer = dungeonLayer;
    }

    public void setTerrain(boolean terrain) {
        this.terrain = terrain;
    }

    public void setTerrainLayer(int terrainLayer) {
        this.terrainLayer = terrainLayer;
    }

    /********************************Metodos publicos*************************************************************/
    /*
     * Metodo update, este se encarga del update del mapa.
     *
     * Recibe el delta del update de la pantalla. (Igual es por si lo vamos a usar en un futuro)
     * */
    public void update(float pDelta) {
        // movementCamera();

        world.step(pDelta, 8, 6);

        this.CAMERA.update();
        this.RENDERER.setView(CAMERA);
        this.RENDERER.render();

        this.renderBox2dHelper.render(world, CAMERA.combined);
        renderBox2D();

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

    public void Box2DMaplayers(int[] pLayers) {
        try {

            for (int layer : pLayers) {
                Box2DHelper box = new Box2DHelper(world);
                box.create2DBoxes(this.MAP, layer);

                BH.add(box);
            }

            if (house) {
                Box2DHelper box = new Box2DHelper(world);
                box.houseObject(this.MAP, houseLayer);
                BH.add(box);
            }
            if (merchant) {
                Box2DHelper box = new Box2DHelper(world);
                box.merchantObject(this.MAP, merchantLayer);
                BH.add(box);
            }
            if (city) {
                Box2DHelper box = new Box2DHelper(world);
                box.cityObject(this.MAP, cityLayer);
                BH.add(box);
            }
            if (dungeon) {
                Box2DHelper box = new Box2DHelper(world);
                box.dungeonObject(this.MAP, dungeonLayer);
                BH.add(box);
            }
            if (terrain) {
                Box2DHelper box = new Box2DHelper(world);
                box.terrainObject(this.MAP, terrainLayer);
                BH.add(box);
            }

        } catch (Exception e) {
            throw e;
        }
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

    private void renderBox2D() {
        for (Box2DHelper box2D : this.BH) {
            box2D.getB2DR().render(this.world, CAMERA.combined);
        }

    }


}



