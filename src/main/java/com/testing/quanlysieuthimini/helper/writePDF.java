package com.testing.quanlysieuthimini.helper;

import com.testing.quanlysieuthimini.BUS.CTPhieuXuatBUS;
import com.testing.quanlysieuthimini.BUS.KhachHangBUS;
import com.testing.quanlysieuthimini.BUS.NhanVienBUS;
import com.testing.quanlysieuthimini.BUS.PhieuXuatBUS;
import com.testing.quanlysieuthimini.BUS.SanPhamBUS;
import com.testing.quanlysieuthimini.DTO.ChiTietPhieuXuatDTO;
import com.testing.quanlysieuthimini.DTO.KhachHangDTO;
import com.testing.quanlysieuthimini.DTO.NhanVienDTO;
import com.testing.quanlysieuthimini.DTO.PhieuXuatDTO;
import com.testing.quanlysieuthimini.DTO.SanPhamDTO;
import com.itextpdf.text.Chunk;
import java.awt.Desktop;
import java.awt.FileDialog;
import java.awt.Point;
import java.awt.Rectangle;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.util.ArrayList;
import java.util.Date;

public class writePDF {

    DecimalFormat formatter = new DecimalFormat("###,###,###");
    SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/YYYY HH:mm");
    Document document = new Document();
    FileOutputStream file;
    JFrame jf = new JFrame();
    FileDialog fd = new FileDialog(jf, "Xuất pdf", FileDialog.SAVE);
    Font fontNormal10;
    Font fontBold15;
    Font fontBold25;
    Font fontBoldItalic15;

    CTPhieuXuatBUS ctpxbus = new CTPhieuXuatBUS();
    KhachHangBUS khbus = new KhachHangBUS();
    NhanVienBUS nvbus = new NhanVienBUS();
    SanPhamBUS spbus = new SanPhamBUS();
    PhieuXuatBUS pxbus = new PhieuXuatBUS();

    public writePDF() {
        try {
            fontNormal10 = new Font(BaseFont.createFont("lib/TimesNewRoman/SVN-Times New Roman.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED), 12, Font.NORMAL);
            fontBold25 = new Font(BaseFont.createFont("lib/TimesNewRoman/SVN-Times New Roman Bold.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED), 25, Font.NORMAL);
            fontBold15 = new Font(BaseFont.createFont("lib/TimesNewRoman/SVN-Times New Roman Bold.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED), 15, Font.NORMAL);
            fontBoldItalic15 = new Font(BaseFont.createFont("lib/TimesNewRoman/SVN-Times New Roman Bold Italic.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED), 15, Font.NORMAL);
        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(writePDF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void chooseURL(String url) {
        try {
            document.close();
            document = new Document();
            file = new FileOutputStream(url);
            PdfWriter writer = PdfWriter.getInstance(document, file);
            document.open();
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Khong tim thay duong dan file " + url);
        } catch (DocumentException ex) {
            JOptionPane.showMessageDialog(null, "Khong goi duoc document !");
        }
    }

    public void setTitle(String title) {
        try {
            Paragraph pdfTitle = new Paragraph(new Phrase(title, fontBold25));
            pdfTitle.setAlignment(Element.ALIGN_CENTER);
            document.add(pdfTitle);
            document.add(Chunk.NEWLINE);
        } catch (DocumentException ex) {
            ex.printStackTrace();
        }
    }

    private String getFile(String name) {
        fd.pack();
        fd.setSize(800, 600);
        fd.validate();
        Rectangle rect = jf.getContentPane().getBounds();
        double width = fd.getBounds().getWidth();
        double height = fd.getBounds().getHeight();
        double x = rect.getCenterX() - (width / 2);
        double y = rect.getCenterY() - (height / 2);
        Point leftCorner = new Point();
        leftCorner.setLocation(x, y);
        fd.setLocation(leftCorner);
        fd.setFile(name);
        fd.setVisible(true);
        String url = fd.getDirectory() + fd.getFile();
        if (url.equals("null")) {
            return null;
        }
        return url;
    }

    private void openFile(String file) {
        try {
            File path = new File(file);
            Desktop.getDesktop().open(path);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static Chunk createWhiteSpace(int length) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            builder.append(" ");
        }
        return new Chunk(builder.toString());
    }

    public PhieuXuatDTO searchPhieu(int maphieu) {
        PhieuXuatDTO result = null;
        ArrayList<PhieuXuatDTO> list = pxbus.phieuXuatDAO.selectAll();
        for (PhieuXuatDTO i : list) {
            if (i.getMaphieuxuat() == maphieu) {
                result = i;
            }
        }
        return result;
    }

    public ChiTietPhieuXuatDTO searchCTPhieu(int maphieu) {
        ChiTietPhieuXuatDTO result = null;
        ArrayList<ChiTietPhieuXuatDTO> list = ctpxbus.ctpxDAO.selectAll();
        for (ChiTietPhieuXuatDTO i : list) {
            if (i.getMaphieuxuat() == maphieu) {
                result = i;
            }
        }
        return result;
    }

    public SanPhamDTO searchSP(int masp) {
        SanPhamDTO result = null;
        ArrayList<SanPhamDTO> list = spbus.spDAO.selectAll();
        for (SanPhamDTO i : list) {
            if (i.getMasp() == masp) {
                result = i;
            }
        }
        return result;
    }

    public void writePX(int maphieu) {
        String url = "";
        try {
            fd.setTitle("In phiếu xuất");
            fd.setLocationRelativeTo(null);
            url = getFile(maphieu + "");
            if (url.equals("nullnull")) {
                return;
            }
            url = url + ".pdf";
            file = new FileOutputStream(url);
            document = new Document();
            PdfWriter writer = PdfWriter.getInstance(document, file);
            document.open();

            Paragraph company = new Paragraph("Hệ Thống Quản Lí Siêu Thị Mi Ni", fontBold15);
            company.add(new Chunk(createWhiteSpace(20)));
            Date today = new Date(System.currentTimeMillis());
            company.add(new Chunk("Thời gian in phiếu: " + formatDate.format(today), fontNormal10));
            company.setAlignment(Element.ALIGN_LEFT);
            document.add(company);
            // Thêm tên công ty vào file PDF
            document.add(Chunk.NEWLINE);
            Paragraph header = new Paragraph("THÔNG TIN PHIẾU XUẤT", fontBold25);
            header.setAlignment(Element.ALIGN_CENTER);
            document.add(header);

            PhieuXuatDTO px = searchPhieu(maphieu);
            Paragraph paragraph1 = new Paragraph("Mã phiếu: PX-" + maphieu, fontNormal10);

            KhachHangDTO kh = khbus.khDAO.selectById(px.getMaphieuxuat() + "");
            String hoten = kh.getHoten();
            Paragraph paragraph2 = new Paragraph("Khách Hàng: " + hoten, fontNormal10);
            paragraph2.add(new Chunk(createWhiteSpace(5)));

            paragraph2.add(new Chunk(createWhiteSpace(5)));

            NhanVienDTO nv = nvbus.nvDAO.selectById("" + px.getMaphieuxuat());
            String ngtao = nv.getHoten();
            Paragraph paragraph3 = new Paragraph("Người thực hiện: " + ngtao, fontNormal10);
            paragraph3.add(new Chunk(createWhiteSpace(5)));

            paragraph3.add(new Chunk(createWhiteSpace(5)));

            paragraph3.add(new Chunk("Mã nhân viên: " + nv.getManv(), fontNormal10));
            Paragraph paragraph4 = new Paragraph("Thời gian nhập: " + formatDate.format(px.getThoigian()), fontNormal10);
            document.add(paragraph1);
            document.add(paragraph2);
            document.add(paragraph3);
            document.add(paragraph4);
            document.add(Chunk.NEWLINE);
            // Thêm table 5 cột vào file PDF
            PdfPTable table = new PdfPTable(4);
            table.setWidthPercentage(100);
            table.setWidths(new float[]{30f, 35f, 20f, 15f});
            PdfPCell cell;
            table.addCell(new PdfPCell(new Phrase("Mã sản phẩm", fontBold15)));
            table.addCell(new PdfPCell(new Phrase("Tên sản phẩm", fontBold15)));
            table.addCell(new PdfPCell(new Phrase("Số lượng", fontBold15)));
            table.addCell(new PdfPCell(new Phrase("Giá", fontBold15)));
            for (int i = 0; i < 4; i++) {
                cell = new PdfPCell(new Phrase(""));
                table.addCell(cell);
            }

            ChiTietPhieuXuatDTO ctpx = ctpxbus.ctpxDAO.selectById(px.getMaphieuxuat() + "");
            SanPhamDTO sp = spbus.spDAO.selectById("" + ctpx.getMasp());

            table.addCell(new PdfPCell(new Phrase(sp.getMasp() + "", fontNormal10)));
            table.addCell(new PdfPCell(new Phrase(sp.getTensp(), fontNormal10)));
            table.addCell(new PdfPCell(new Phrase(ctpx.getSoluong() + "", fontNormal10)));
            table.addCell(new PdfPCell(new Phrase(ctpx.getDongia() + "", fontNormal10)));

//            }
            document.add(table);
            document.add(Chunk.NEWLINE);

            Paragraph paraTongThanhToan = new Paragraph(new Phrase("Tổng thành tiền: " + formatter.format(px.getTongtien()) + "đ", fontBold15));
            paraTongThanhToan.setIndentationLeft(300);

            document.add(paraTongThanhToan);
            document.add(Chunk.NEWLINE);
            document.add(Chunk.NEWLINE);
            Paragraph paragraph = new Paragraph();
            paragraph.setIndentationLeft(22);
            paragraph.add(new Chunk("Người lập phiếu", fontBoldItalic15));
            paragraph.add(new Chunk(createWhiteSpace(30)));
            paragraph.add(new Chunk("Người giao", fontBoldItalic15));
            paragraph.add(new Chunk(createWhiteSpace(30)));
            paragraph.add(new Chunk("Khách hàng", fontBoldItalic15));

            Paragraph sign = new Paragraph();
            sign.setIndentationLeft(20);
            sign.add(new Chunk("(Ký và ghi rõ họ tên)", fontNormal10));
            sign.add(new Chunk(createWhiteSpace(25)));
            sign.add(new Chunk("(Ký và ghi rõ họ tên)", fontNormal10));
            sign.add(new Chunk(createWhiteSpace(23)));
            sign.add(new Chunk("(Ký và ghi rõ họ tên)", fontNormal10));
            document.add(paragraph);
            document.add(sign);
            document.close();
            writer.close();
            openFile(url);

        } catch (DocumentException | FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi khi ghi file " + url);
        }
    }

}
