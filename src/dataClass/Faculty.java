package dataClass;
import exception.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Formatter;

public class Faculty implements Serializable {
  private static final String[] courseCodeOfAccountingAndFinance={"ACT201","ACT202", "ACT310","ACT320","ACT370","ACT380",
    "ACT410","ACT430","ACT46","FIN225","FIN433","FIN435","FIN440","FIN444","FIN455","FIN464","FIN480"};
  private static final String[] courseCodeOfArchitecture={"ARC111","ARC112","ARC121","ARC122","ARC123","ARC131","ARC133","ARC200",
    "ARC213","ARC214","ARC215","ARC241","ARC242","ARC251","ARC261","ARC262","ARC263", "ARC264","ARC271", "ARC272",
    "ARC273","ARC281","ARC282","ARC283"};
  private static final String[] courseCodeOfBiochemistryAndMicrobiology={"BBT202","BBT203","BBT221","BBT223","BBT312","BBT403",
    "BBT404","BBT405,","BBT406","BBT410","BBT702","BBT741","BBT745","BIO103","BIO201","BIO202","CHE101","CHE120",
    "CHE201","CHE202","CHE203","MIC101","MIC101L","MIC110","MIC110L","MIC201","MIC202","MIC203","MIC206","MIC207",
    "MIC307","MIC309","MIC311","MIC314","MIC315","MIC316","MIC317","MIC417","MIC498","MIC499","PSY101","PSY101L"};
  private static final String[] courseCodeOfCivilAndEnvironmentalEngineering={"CEE100","CEE110","CEE209","CEE209L","CEE210",
    "CEE211","CEE211L","CEE212","CEE212L","CEE213","CEE213L","CEE214","CEE214L","CEE215","CEE215L","CEE335",
    "CEE335L","CEE340","CEE350","CEE360","CEE360L"};
  private static final String[] courseCodeOfEconomics={"ECO101","ECO102","ECO103","ECO104","ECO135","ECO172","ECO173","ECO201",
    "ECO204","ECO245","ECO301","ECO303","ECO304","ECO348","ECO372","ECO380","ECO406","ECO415","ECO455","ECO490",
    "ECO495","ECO496","ECO499","ECO501","ECO503","ECO651","ECO689","ECO695","ECO699"};
  private static final String[] courseCodeOfEnglishAndModernLanguages={"ENG102","ENG103","ENG105","ENG111","ENG115","ENG216",
    "ENG220","ENG230","ENG312","ENG337","ENG341","ENG346","ENG371","ENG381", "ENG406","ENG416","ENG417","ENG429",
    "ENG436","ENG441","ENG456","ENG466","ENG471","ENG490","ENG491","ENG570","ENG571","ENG578","ENG579", "ENG580",
    "ENG603","ENG606","ENG613","ENG618","ENG632","ENG635","ENG637","BEN205"};
  private static final String[] courseCodeOfEnvironmentalScienceAndManagement={"ENV102","ENV107","ENV172","ENV203","ENV204",
    "ENV205","ENV207","ENV208","ENV209","ENV214","ENV260","ENV307","ENV313","ENV316","ENV373","ENV408","ENV410","ENV421",
    "ENV430","ENV432","ENV436","ENV455","ENV498","ENV499","ENV502","ENV602","ENV606","ENV627","ENV629","ENV652","ENV690",
    "ENV697","GEO205"};
  private static final String[] courseCodeOfElectricalAndComputerEngineering={"ANT101","CSE115","CSE15L","CSE173","CSE215","CSE215L",
    "CSE225","CSE225L","CSE231","CSE231L","CSE299","CSE302","CSE311","CSE323","CSE373","CSE425","CSE499A","CSE499B",
    "EEE111", "EEE111L", "EEE141","EEE141L", "EEE151", "EEE211","EEE211L","EEE232", "EEE232L", "EEE241", "EEE241L",
    "EEE254", "EEE280", "EEE299", "EEE311", "EEE311L", "EEE321","EEE321L","EEE331","EEE332", "EEE332L","EEE333",
    "EEE336","EEE520","EEE534","EEE595","EEE596","EEE597","EEE600","EEE660","ETE111","ETE11L","ETE141","ETE141L",
    "ETE211","ETE211L","ETE221","ETE221L","ETE241","ETE241L","ETE299","ETE311","ETE311L","ETE331","ETE498R",
    "ETE499A","ETE499B","ETE504","ETE596","ETE597"};
  private static final String[] courseCodeOfHistoryAndPhilosophy={"ETH201","HIS101","HIS102","HIS103","HIS203","HIS205","PHI101",
    "PHI104","PHI401"};
  private static final String[] courseCodeOfLaw={"LAW101","LAW103","LAW107","LAW200","LAW201","LAW205","LAW208","LAW209","LAW211",
    "LAW213","LAW225","LAW301","LAW303","LAW305","LAW310","LAW313","LAW314","LAW402","LAW415","LAW416","LAW417","LAW419",
    "LAW420","LAW421","LAW422","LAW423","LAW424","LAW426","LAW427","LLM505","LLM506","LLM508","LLM509","LLM514","LLM515," +
                                                                                                                  "LLM516"};
  private static final String[] courseCodeOfManagement={"HRM340","HRM360","HRM370","HRM380","HRM450","HRM460","HRM470","HRM603",
    "HRM604","HRM605","HRM610","HRM660","HRM680","MGT321","MGT330","MGT351","MGT368","MGT410","MGT460","MGT489","MGT490",
    "MGT601","MGT610","MGT656","MGT680","MIS460","MIS470","MIS660","MIS666","SCM310", "SCM320","SCM450"};
  private static final String[] courseCodeOfMarketingAndInternationalBusiness={"BUS112","BUS135","BUS172","BUS173","BUS251",
    "BUS498","BUS500","BUS501","BUS505","BUS511","BUS516","BUS518","BUS520","BUS525","BUS530","BUS690","BUS698",
    "BUS699","BUS700","DEV503", "DEV567","DEV570","DEV572","DEV573","DEV595","DEV596", "EMB501","EMB502","EMB502",
    "EMB510","EMB520","EMB601","EMB602","EMB620","EMB650","EMB660", "EMB670","EMB690","INB350","INB355","INB372",
    "INB400","INB410","INB415","INB450","INB480","INB490","INB495","MKT202","MKT330","MKT337","MKT344","MKT355",
    "MKT382","MKT412","MKT445","MKT450","MKT460","MKT465","MKT470","MKT475","MKT621","MKT623","MKT627","MKT628","MKT631",
    "MKT633","MKT634","MKT636"};
  private static final String[] courseCodeOfMathematicsAndPhysics={"BSC201","MAT116","MAT120","MAT125","MAT130","MAT140",
    "MAT250","MAT260","MAT350","MAT361","MAT370","MAT480","PHY107","PHY107L", "PHY108", "PHY108L" };
  private static final String[] courseCodeOfPharmaceuticalSciences={"PHR5001","PHR5002","PHR5003","PHR5011", "PHR5012","PHR5013",
    "PHR5015", "PHR5022 ", "PHR5023", "PHR5101", "PHR5106", "PHR5107", "PHR5108", "PHR5208", "PHR5209"};
  private static final String[] courseCodeOfPoliticalScienceAndSociology={"POL101","POL102","POL202","PPG525","PPG530","PPG565",
    "SOC101", "SOC201"};
  private static final String[] courseCodeOfPublicHealth={"PBH101", "PBH604", "PBH605", "PBH609", "PBH611", "PBH631", "PBH642",
    "PBH771", "PBH805", "PBH806", "PBH842","EMPH601", "EMPH602", "EMPH605", "EMPH609","EMPH611","EMPH631", "EMPH644",
    "EMPH678", "EMPH681", "EMPH704","EMPH706","EMPH711", "EMPH712", "EMPH782","EMPH805","EMPH806","EMPH842"};
  
  private String facultyInitial;
  private String email;
  private String ID;
  private String department;
  private String semester;
  private int studentList;
  private String purpose;
  private String classroomName;
  private String courseCode;
  private LocalDate localDate;
  private String profilePath;
  
  public Faculty(String facultyInitial, String email, String ID,String email1, String department,
                 String semester, int studentList, String purpose, String classroomName, LocalDate localDate, String courseCode, String profilePath) throws Exception {
    this.setEmail(email);
    this.setFacultyInitial(facultyInitial);
    this.setID(ID);
    this.setDepartment(department);
    this.setSemester(semester);
    this.setStudentList(studentList);
    this.setPurpose(purpose);
    this.setClassroomName(classroomName);
    this.setLocalDate(localDate);
    this.setCourseCode(courseCode);
    this.setProfilePath(profilePath);
  }
  
  public String getFacultyInitial() {
    return facultyInitial;
  }
  
  public void setFacultyInitial(String facultyInitial) throws Exception {
    if (facultyInitial.length() > 4 || facultyInitial.equals("")) {
      throw new InvalidFacultyInitial("Invalid Faculty Initial");
    }
    this.facultyInitial = facultyInitial;
  }
  
  public String getID() {
    return ID;
  }
  
  public void setID(String ID) throws Exception {
    if (ID.equals("")){
      throw new InvalidID("Invalid ID");
    }
    else if (ID.length() < 7 || ID.length() > 10) {
      throw new InvalidID("Invalid ID");
    }
    this.ID = ID;
  }
  
  public String getDepartment() {
    return department;
  }
  
  public void setDepartment(String department) throws Exception {
    this.department = department;
  }
  
  public String getSemester() {
    return semester;
  }
  
  public void setSemester(String semester) throws Exception {
   if (semester.equals("")){
     throw new InvalidSemester("Invalid Semester");
   } else if(!semester.equals("Spring 2021")){
     throw  new InvalidSemester("Invalid Semester");
   }
   this.semester = semester;
  }
  
  public int getStudentList() {
    return studentList;
  }
  
  public void setStudentList(int studentList) throws Exception {
    if ((studentList < 15) || (studentList > 45)) {
      throw new InvalidStudentList("Invalid Student List");
    }
    this.studentList = studentList;
  }
  
  public String getPurpose() {
    return purpose;
  }
  
  public void setPurpose(String purpose) throws Exception {
    this.purpose = purpose;
  }
  
  public String getClassroomName() {
    return classroomName;
  }
  
  public void setClassroomName(String classroomName) throws Exception {
    if (classroomName.equals("")){
      throw new InvalidClassroom("Invalid Classroom");
    }
    this.classroomName = classroomName;
  }
  
  public LocalDate getLocalDate() {
    return localDate;
  }
  
  public void setLocalDate(LocalDate localDate) throws Exception {
    LocalDate localDate1 = LocalDate.now();
    if (localDate.equals(null)){
      throw new InvalidDate("Invalid Date");
    } else if(localDate.isBefore(localDate1) ){
      throw  new InvalidDate("Invalid Date");
    }
    this.localDate = localDate;
  }
  
  public String getCourseCode() {
    return courseCode;
  }
  
  public void setCourseCode(String courseCode) throws Exception {
//    if (this.department.equals("Department of Electrical and Computer Engineering")){
//      for (int i = 0; i < courseCodeOfElectricalAndComputerEngineering.length; i++) {
//        if (!courseCode.equals(courseCodeOfElectricalAndComputerEngineering[i])) {
//          throw new InvalidCourseCode("Invalid Course Code");
//        }
//      }
//    } else {
//      this.courseCode = courseCode;
//    }
//
    if (courseCode.equals("")){
      throw new InvalidCourseCode("Invalid Course Code");
    }
    this.courseCode = courseCode;
  }
  
  public String getProfilePath() {
    return profilePath;
  }
  
  public void setProfilePath(String profilePath) throws Exception {
    if (profilePath.equals(null)){
      throw new InvalidProfilePicture("Invalid Profile picture");
    }
    this.profilePath = profilePath;
  }
  
  public String getEmail() {
    return email;
  }
  
  public void setEmail(String email) throws Exception {
    if (email.equals("")){
      throw new InvalidEmail("Invalid Email");
    }
    else if (email.contains("@northsouth.edu")) {
      this.email = email;
    }else{
      throw new InvalidEmail("Invalid Email");
    }
  }
  
  @Override
  public String toString() {
    Formatter formatter = new Formatter(new StringBuilder());
    formatter.format("%s %s %s %s %s %s %s %s %s %s %s",this.facultyInitial,this.email,this.ID,this.department,this.semester,this.courseCode,this.studentList,
      this.purpose,this.classroomName,this.localDate,this.profilePath);
    return formatter.toString();
  }
}
