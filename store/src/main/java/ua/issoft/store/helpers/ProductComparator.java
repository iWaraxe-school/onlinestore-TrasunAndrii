package ua.issoft.store.helpers;

import ua.issoft.domain.Product;

import java.lang.reflect.Field;
import java.util.Comparator;
import java.util.Map;

public class ProductComparator implements Comparator<Product> {

    public ProductComparator(String pathnameXML) {
        this.pathnameXML = pathnameXML;
    }

    String pathnameXML;

    @Override
    public int compare(Product p1, Product p2) {
        XMLParser xmlParser = new XMLParser(pathnameXML);
        Map<String, String> configMap = xmlParser.getConfigMap();
        int result = 0;
        Class<Product> productClass = Product.class;
        Field[] productFields = productClass.getDeclaredFields();
        for (String sortName : configMap.keySet()) {
            for (Field productField : productFields) {
                if (sortName.equals(productField.getName())) {
                    productField.setAccessible(true);
                    String productFieldName = productField.getType().getSimpleName();
                    try {
                        switch (productFieldName) {
                            case "String":
                                String stringP1 = (String) productField.get(p1);
                                String stringP2 = (String) productField.get(p2);
                                if (configMap.get(sortName).equals("asc")) {
                                    result = stringP1.compareToIgnoreCase(stringP2);
                                } else {
                                    result = stringP2.compareToIgnoreCase(stringP1);
                                }
                                break;
                            case "int":
                                Integer integerP1 = (Integer) productField.get(p1);
                                Integer integerP2 = (Integer) productField.get(p2);
                                if (configMap.get(sortName).equals("asc")) {
                                    result = Integer.compare(integerP1, integerP2);
                                } else {
                                    result = Integer.compare(integerP2, integerP1);
                                }
                                break;
                            default:
                                System.out.println("We so sorry. We have no 'case' for that Class.");
                                break;
                        }
                        if (result != 0) {
                            return result;
                        }
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
        return result;
    }
}
