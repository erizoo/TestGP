import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class XMLstaxParser {

    public static void main(String[] args) {
        String fileName = "D:/Task1.xml";
        List<TouristFromXml> touristFromXmlList = parseXMLfile(fileName);
        // печатаем в консоль информацию по каждому студенту
        for (TouristFromXml touristFromXml : touristFromXmlList) {
            System.out.println(
                    touristFromXml.toString());
        }
        List<Tourist> touristList = addToList(touristFromXmlList);

    }

    private static List<TouristFromXml> parseXMLfile(String fileName) {
        List<TouristFromXml> studentsList = new ArrayList<>();
        TouristFromXml touristFromXml = null;
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        try {
            // инициализируем reader и скармливаем ему xml файл
            XMLEventReader reader = xmlInputFactory.createXMLEventReader(new FileInputStream(fileName));
            // проходим по всем элементам xml файла
            while (reader.hasNext()) {
                // получаем событие (элемент) и разбираем его по атрибутам
                XMLEvent xmlEvent = reader.nextEvent();
                if (xmlEvent.isStartElement()) {
                    StartElement startElement = xmlEvent.asStartElement();
                    if (startElement.getName().getLocalPart().equals("tourists")) {
                        touristFromXml = new TouristFromXml();
                        xmlEvent = reader.nextEvent();
                        try {
                            touristFromXml.setTourists(xmlEvent.asCharacters().getData());
                        } catch (Exception e){
                            System.out.println("Error" + e);
                        }

                    }
                }
                // если цикл дошел до закрывающего элемента Student,
                // то добавляем считанного из файла студента в список
                if (xmlEvent.isEndElement()) {
                    EndElement endElement = xmlEvent.asEndElement();
                    if (endElement.getName().getLocalPart().equals("tourists")) {
                        studentsList.add(touristFromXml);
                    } else {
                        break;
                    }
                }
            }

        } catch (FileNotFoundException | XMLStreamException exc) {
            exc.printStackTrace();
        }
        return studentsList;
    }

    public static List<Tourist> addToList(List<TouristFromXml> touristFromXmls){
        List<Tourist> listTourist = new ArrayList<>();
        for (TouristFromXml list: touristFromXmls)  {
            String str = list.getTourists();
            String[] strItem = str.split("|");
            System.out.println(Arrays.toString(strItem));
        }

        return listTourist;
    }
}
