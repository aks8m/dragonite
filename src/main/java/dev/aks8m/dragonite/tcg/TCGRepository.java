package dev.aks8m.dragonite.tcg;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class TCGRepository {

    private static final Logger LOG = LoggerFactory.getLogger(TCGRepository.class);

    private enum IdNamespace {
        GAME(56), //byte
        SET(32), //int
        SERIES(16); //int

        private final int bitShift;

        IdNamespace(int bitShift) {
            this.bitShift = bitShift;
        }

        public int getBitShift() {
            return bitShift;
        }
    }

    private final ConcurrentHashMap<IdNamespace, Short> idTracker;
    private final ConcurrentHashMap<String, Short> seriesDatastore;
    private final ConcurrentHashMap<String, Short> setDatastore;
    private final ConcurrentHashMap<Short, List<Short>> seriesToSetMap;
    private final ConcurrentHashMap<String, Short> categoryDatastore;
    //need something for reprints of cards in different sets - the name may suffice, but I don't know

    public TCGRepository() {
        this.idTracker = new ConcurrentHashMap<>();
        this.seriesDatastore = new ConcurrentHashMap<>();
        this.setDatastore = new ConcurrentHashMap<>();
        this.seriesToSetMap = new ConcurrentHashMap<>();
        this.categoryDatastore = new ConcurrentHashMap<>();

        this.idTracker.put(IdNamespace.SERIES, (short) 0);
        this.idTracker.put(IdNamespace.SET, (short) 0);
    }
//
//    public ConcurrentHashMap<String, Short> getSeriesDatastore() {
//        return seriesDatastore;
//    }
//
//    public ConcurrentHashMap<String, Short> getSetDatastore() {
//        return setDatastore;
//    }
//
//    public ConcurrentHashMap<String, Short> getCategoryDatastore() {
//        return categoryDatastore;
//    }
//
//    public LongObjectHashMap<Card> getCardDatabase() {
//        return cardDatabase;
//    }
//
//    public void loadPokemonSeries(String namespace, SerieResume[] seriesResumes) {
//        int loadCount = 0;
//        for (SerieResume serieResume : seriesResumes) {
//            String key = namespace + "|" + serieResume.getId();
//            short id = (short) (idTracker.get(IdNamespace.SERIES) + 1);
//            if (seriesDatastore.putIfAbsent(key, id) == null) {
//                loadCount++;
//                idTracker.put(IdNamespace.SERIES, id);
//            }
//        }
//        LOG.info("Loaded {}  {} series", loadCount, namespace);
//    }
//
//    public void loadPokemonSets(String namespace, SetResume[] setResumes) {
//        int loadCount = 0;
//        for (SetResume setResume : setResumes) {
//            String key = namespace + "|" + setResume.getId();
//            short id = (short) (idTracker.get(IdNamespace.SET) + 1);
//            if (setDatastore.putIfAbsent(key, id) == null) {
//                loadCount++;
//                idTracker.put(IdNamespace.SET, id);
//            }
//        }
//        LOG.info("Loaded {}  {} sets", loadCount, namespace);
//    }
//
//    public void loadPokemonCategories(String namespace, String[] categories) {
//        int loadCount = 0;
//        for (String category : categories) {
//            String key = namespace + "|" + category;
//            short id = (short) (idTracker.get(IdNamespace.CATEGORY) + 1);
//            if (categoryDatastore.putIfAbsent(key, id) == null) {
//                loadCount++;
//                idTracker.put(IdNamespace.CATEGORY, id);
//            }
//        }
//        LOG.info("Loaded {}  {} categories", loadCount, namespace);
//    }
//
//    public void loadPokemonSeriesToSetMap(String namespace, Serie serie) {
//        int loadCount = 0;
//        String key = namespace + "|" + serie.getId();
//        short seriesId = seriesDatastore.get(key);
//        for (SetResume setResume : serie.getSets()) {
//            String setKey = namespace + "|" + setResume.getId();
//            short setId = setDatastore.get(setKey);
//            if (seriesToSetMap.containsKey(seriesId)) {
//                seriesToSetMap.get(seriesId).add(setId);
//            } else {
//                List<Short> setList = new ArrayList<>();
//                setList.add(setId);
//                seriesToSetMap.put(seriesId, setList);
//            }
//            loadCount++;
//        }
//        LOG.info("Loaded {}  {} series to set maps", loadCount, namespace);
//    }
//
//    public void loadPokemonCards(String namespace, Card[] cards) {
//        int loadCount = 0;
//        for (Card card : cards) {
//            //Figure out Series Id
//            //Figure out Set Id
//            //Figure out Category Id
//            //Get local card Id
//        }
//        LOG.info("Loaded {}  {} cards", loadCount, namespace);
//    }
}
