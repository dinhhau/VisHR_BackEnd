package vn.vissoft.portal.services;

import org.docx4j.Docx4J;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import vn.vissoft.portal.config.WordTemplateFiller;
import vn.vissoft.portal.entities.FillData;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FillDataService {

    private static final Logger LOG = LoggerFactory.getLogger(FillDataService.class);

    @Value("${config.path_upload}")
    private String urlUpload;

    public void meo(FillData fill) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder buider = factory.newDocumentBuilder();
            Document doc = buider.newDocument();

            Element employee = doc.createElement("Nhan_vien");
            doc.appendChild(employee);

            Element contract_code = doc.createElement("Ma_hop_dong");
            contract_code.appendChild(doc.createTextNode(fill.getContractcode()));
            employee.appendChild(contract_code);

            Element name = doc.createElement("Ho_ten");
            name.appendChild(doc.createTextNode(fill.getName()));
            employee.appendChild(name);

            Element birthday = doc.createElement("Ngay_sinh");
            birthday.appendChild(doc.createTextNode(fill.getBirthday()));
            employee.appendChild(birthday);

            Element job = doc.createElement("Nghe_nghiep");
            job.appendChild(doc.createTextNode(fill.getJob()));
            employee.appendChild(job);

            Element address = doc.createElement("Dia_chi");
            address.appendChild(doc.createTextNode(fill.getAddress()));
            employee.appendChild(address);

            Element cmt = doc.createElement("So_CMT");
            cmt.appendChild(doc.createTextNode(fill.getCmt()));
            employee.appendChild(cmt);

            Element datecmt = doc.createElement("Ngay_cap");
            datecmt.appendChild(doc.createTextNode(fill.getDatecmt()));
            employee.appendChild(datecmt);

            Element addresscmt = doc.createElement("Dia_chi_CMT");
            addresscmt.appendChild(doc.createTextNode(fill.getAddresscmt()));
            employee.appendChild(addresscmt);

            Element manager = doc.createElement("Nguoi_quan_ly");
            manager.appendChild(doc.createTextNode(fill.getManager()));
            employee.appendChild(manager);

            Element time = doc.createElement("Han_hop_dong");
            time.appendChild(doc.createTextNode(fill.getTime()));
            employee.appendChild(time);

            Element title = doc.createElement("Chuc_danh");
            title.appendChild(doc.createTextNode(fill.getTitle()));
            employee.appendChild(title);

            Element salary = doc.createElement("Luong");
            salary.appendChild(doc.createTextNode(fill.getSalary()));
            employee.appendChild(salary);

            Element validity = doc.createElement("Ngay_hieu_luc");
            validity.appendChild(doc.createTextNode(fill.getValidity()));
            employee.appendChild(validity);

            Element startdate = doc.createElement("Ngay_bat_dau");
            startdate.appendChild(doc.createTextNode(fill.getStartdate()));
            employee.appendChild(startdate);

            Element enddate = doc.createElement("Ngay_ket_thuc");
            enddate.appendChild(doc.createTextNode(fill.getEnddate()));
            employee.appendChild(enddate);

            Element school = doc.createElement("Truong_hoc");
            school.appendChild(doc.createTextNode(fill.getSchool()));
            employee.appendChild(school);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();

            DOMSource source = new DOMSource(doc);
            File f = new File(urlUpload + "/XML/contract.xml");
            StreamResult result = new StreamResult(f);
            transformer.transform(source, result);
        } catch (Exception e) {
            e.printStackTrace();
            LOG.error(e.toString(), e);
        }
    }

    public void fill(String name, String type) {
        try {
            Path xmlDataPath = Paths.get(urlUpload + "/XML/contract.xml");
            Path wordTemplatePath = Paths.get(urlUpload + "/Template/" + type);
            Path wordOutputPath = Paths.get(urlUpload + "/Contract/" + name);
            if (Files.exists(wordOutputPath))
                Files.delete(wordOutputPath);
            WordTemplateFiller wordTemplateFiller = new WordTemplateFiller();
            wordTemplateFiller.generateWord(wordTemplatePath.toString(), xmlDataPath.toString(), wordOutputPath.toString());
            String fileData = Docx4J.load(new File(wordOutputPath.toString())).getMainDocumentPart().getContent().get(1).toString();
        } catch (Exception e) {
            e.printStackTrace();
            LOG.error(e.toString(), e);
        }
    }
}
