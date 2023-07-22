package com.example.javaandspring.clean_code;

public class Formalization형식맞추기_밥아저씨형식 {
    // - while, for문은 피하자

    // - 형식 맞추기
        // - 신문 기사처럼 작성하라(위에서 ~ 아래로 읽음)
        // - 서로 밀집한 코드 행은 세로로 가까이 놓여야 함
        // - 변수는 사용되는 위치에 최대한 가까이 선언!(수석님이 말씀해주신거 ㅇㅋㅇㅋ)
        //   보통 우리가 만든 함수는 짧으므로 '지역 변수'는 각 함수 맨처음에 선언함(ㅇㅋㅇㅋ)
        // - 인스턴스 변수는 '클래스 맨 처음에 선언'
    private String instanceVariable;    // 인스턴스 변수

        // - 한 함수가 다른 함수를 호출하면 두 함수는 세로로 가까이 배치 ㅇㅇ
        //   가능하면 호출하는 함수가 호출되는 함수보다 먼저 (ㅇㅋ)
    public void callMethod() {
        // 호출하는 함수
        calledMethod();
    }

    private void calledMethod() {
        // 호출되는 함수
    }

        // - 가로 형식 (45자 근처)은 짧을 수록 좋다

    // - 팀 규칙은 보통 밥아저씨의 형식 규칙을 따라 작성함
        // public class CodeAnalyzer implements JavaFileAnalysis {
        //  private int lineCount;
        //  private int maxLineWidth;
        //  private int widestLineNumber;
        //  private LineWidthHistogram lineWidthHistogram;
        //  private int totalChars;
        //
        //  public CodeAnalyzer() {
        //    lineWidthHistogram = new LineWidthHistogram();
        //  }
        //
        //  public static List<File> findJavaFiles(File parentDirectory) {
        //    List<File> files = new ArrayList<File>();
        //    findJavaFiles(parentDirectory, files);
        //    return files;
        //  }
        //
        //  private static void findJavaFiles(File parentDirectory, List<File> files) {
        //    for (File file : parentDirectory.listFiles()) {
        //      if (file.getName().endsWith(".java"))
        //        files.add(file);
        //      else if (file.isDirectory())
        //        findJavaFiles(file, files);
        //    }
        //  }
        //
        //  public void analyzeFile(File javaFile) throws Exception {
        //    BufferedReader br = new BufferedReader(new FileReader(javaFile));
        //    String line;
        //    while ((line = br.readLine()) != null)
        //      measureLine(line);
        //  }
        //
        //  private void measureLine(String line) {
        //    lineCount++;
        //    int lineSize = line.length();
        //    totalChars += lineSize;
        //    lineWidthHistogram.addLine(lineSize, lineCount);
        //    recordWidestLine(lineSize);
        //  }
        //
        //  private void recordWidestLine(int lineSize) {
        //    if (lineSize > maxLineWidth) {
        //      maxLineWidth = lineSize;
        //      widestLineNumber = lineCount;
        //    }
        //  }
        //
        //  public int getLineCount() {
        //    return lineCount;
        //  }
        //
        //  public int getMaxLineWidth() {
        //    return maxLineWidth;
        //  }
        //
        //  public int getWidestLineNumber() {
        //    return widestLineNumber;
        //  }
        //
        //  public LineWidthHistogram getLineWidthHistogram() {
        //    return lineWidthHistogram;
        //  }
        //
        //  public double getMeanLineWidth() {
        //    return (double)totalChars/lineCount;
        //  }
        //
        //  public int getMedianLineWidth() {
        //    Integer[] sortedWidths = getSortedWidths();
        //    int cumulativeLineCount = 0;
        //    for (int width : sortedWidths) {
        //      cumulativeLineCount += lineCountForWidth(width);
        //      if (cumulativeLineCount > lineCount/2)
        //        return width;
        //    }
        //    throw new Error("Cannot get here");
        //  }
        //
        //  private int lineCountForWidth(int width) {
        //    return lineWidthHistogram.getLinesforWidth(width).size();
        //  }
        //
        //  private Integer[] getSortedWidths() {
        //    Set<Integer> widths = lineWidthHistogram.getWidths();
        //    Integer[] sortedWidths = (widths.toArray(new Integer[0]));
        //    Arrays.sort(sortedWidths);
        //    return sortedWidths;
        //  }
        //}

}


