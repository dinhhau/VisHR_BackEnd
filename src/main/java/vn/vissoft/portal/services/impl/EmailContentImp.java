package vn.vissoft.portal.services.impl;

import org.springframework.stereotype.Service;
import vn.vissoft.portal.entities.PasswordResetToken;
import vn.vissoft.portal.services.EmailContent;

@Service
public class EmailContentImp implements EmailContent {

    @Override
    public String emailSendToApprover(
            String username,
            String fullName,
            String dateBegin,
            String dateEnd,
            String reasonName,
            String description,
            String approver,
            String approverName,
            String managerLv2
    ) {

        String emailContent =
                "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional //EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
                        "<html xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:v=\"urn:schemas-microsoft-com:vml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\">\n" +
                        "\n" +
                        "<head>\n" +
                        "\t<!--[if gte mso 9]><xml><o:OfficeDocumentSettings><o:AllowPNG/><o:PixelsPerInch>96</o:PixelsPerInch></o:OfficeDocumentSettings></xml><![endif]-->\n" +
                        "\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\n" +
                        "\t<meta name=\"viewport\" content=\"width=device-width\">\n" +
                        "\t<!--[if !mso]><!-->\n" +
                        "\t<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
                        "\t<!--<![endif]-->\n" +
                        "\t<title></title>\n" +
                        "\t<!--[if !mso]><!-->\n" +
                        "\t<link href=\"https://fonts.googleapis.com/css?family=Montserrat\" rel=\"stylesheet\" type=\"text/css\">\n" +
                        "\t<!--<![endif]-->\n" +
                        "\t<style type=\"text/css\">\n" +
                        "\t\tbody {\n" +
                        "\t\t\tmargin: 0;\n" +
                        "\t\t\tpadding: 0;\n" +
                        "\t\t}\n" +
                        "\n" +
                        "\t\ttable,\n" +
                        "\t\ttd,\n" +
                        "\t\ttr {\n" +
                        "\t\t\tvertical-align: top;\n" +
                        "\t\t\tborder-collapse: collapse;\n" +
                        "\t\t}\n" +
                        "\n" +
                        "\t\t* {\n" +
                        "\t\t\tline-height: inherit;\n" +
                        "\t\t}\n" +
                        "\n" +
                        "\t\ta[x-apple-data-detectors=true] {\n" +
                        "\t\t\tcolor: inherit !important;\n" +
                        "\t\t\ttext-decoration: none !important;\n" +
                        "\t\t}\n" +
                        "\t</style>\n" +
                        "\t<style type=\"text/css\" id=\"media-query\">\n" +
                        "\t\t@media (max-width: 620px) {\n" +
                        "\n" +
                        "\t\t\t.block-grid,\n" +
                        "\t\t\t.col {\n" +
                        "\t\t\t\tmin-width: 320px !important;\n" +
                        "\t\t\t\tmax-width: 100% !important;\n" +
                        "\t\t\t\tdisplay: block !important;\n" +
                        "\t\t\t}\n" +
                        "\n" +
                        "\t\t\t.block-grid {\n" +
                        "\t\t\t\twidth: 100% !important;\n" +
                        "\t\t\t}\n" +
                        "\n" +
                        "\t\t\t.col {\n" +
                        "\t\t\t\twidth: 100% !important;\n" +
                        "\t\t\t}\n" +
                        "\n" +
                        "\t\t\t.col>div {\n" +
                        "\t\t\t\tmargin: 0 auto;\n" +
                        "\t\t\t}\n" +
                        "\n" +
                        "\t\t\timg.fullwidth,\n" +
                        "\t\t\timg.fullwidthOnMobile {\n" +
                        "\t\t\t\tmax-width: 100% !important;\n" +
                        "\t\t\t}\n" +
                        "\n" +
                        "\t\t\t.no-stack .col {\n" +
                        "\t\t\t\tmin-width: 0 !important;\n" +
                        "\t\t\t\tdisplay: table-cell !important;\n" +
                        "\t\t\t}\n" +
                        "\n" +
                        "\t\t\t.no-stack.two-up .col {\n" +
                        "\t\t\t\twidth: 50% !important;\n" +
                        "\t\t\t}\n" +
                        "\n" +
                        "\t\t\t.no-stack .col.num4 {\n" +
                        "\t\t\t\twidth: 33% !important;\n" +
                        "\t\t\t}\n" +
                        "\n" +
                        "\t\t\t.no-stack .col.num8 {\n" +
                        "\t\t\t\twidth: 66% !important;\n" +
                        "\t\t\t}\n" +
                        "\n" +
                        "\t\t\t.no-stack .col.num4 {\n" +
                        "\t\t\t\twidth: 33% !important;\n" +
                        "\t\t\t}\n" +
                        "\n" +
                        "\t\t\t.no-stack .col.num3 {\n" +
                        "\t\t\t\twidth: 25% !important;\n" +
                        "\t\t\t}\n" +
                        "\n" +
                        "\t\t\t.no-stack .col.num6 {\n" +
                        "\t\t\t\twidth: 50% !important;\n" +
                        "\t\t\t}\n" +
                        "\n" +
                        "\t\t\t.no-stack .col.num9 {\n" +
                        "\t\t\t\twidth: 75% !important;\n" +
                        "\t\t\t}\n" +
                        "\n" +
                        "\t\t\t.video-block {\n" +
                        "\t\t\t\tmax-width: none !important;\n" +
                        "\t\t\t}\n" +
                        "\n" +
                        "\t\t\t.mobile_hide {\n" +
                        "\t\t\t\tmin-height: 0px;\n" +
                        "\t\t\t\tmax-height: 0px;\n" +
                        "\t\t\t\tmax-width: 0px;\n" +
                        "\t\t\t\tdisplay: none;\n" +
                        "\t\t\t\toverflow: hidden;\n" +
                        "\t\t\t\tfont-size: 0px;\n" +
                        "\t\t\t}\n" +
                        "\n" +
                        "\t\t\t.desktop_hide {\n" +
                        "\t\t\t\tdisplay: block !important;\n" +
                        "\t\t\t\tmax-height: none !important;\n" +
                        "\t\t\t}\n" +
                        "\t\t}\n" +
                        "\t</style>\n" +
                        "</head>\n" +
                        "\n" +
                        "<body class=\"clean-body\" style=\"margin: 0; padding: 0; -webkit-text-size-adjust: 100%; background-color: #e2eace;\">\n" +
                        "\t<!--[if IE]><div class=\"ie-browser\"><![endif]-->\n" +
                        "\t<table class=\"nl-container\" style=\"table-layout: fixed; vertical-align: top; min-width: 320px; Margin: 0 auto; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #e2eace; width: 100%;\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" width=\"100%\" bgcolor=\"#e2eace\" valign=\"top\">\n" +
                        "\t\t<tbody>\n" +
                        "\t\t\t<tr style=\"vertical-align: top;\" valign=\"top\">\n" +
                        "\t\t\t\t<td style=\"word-break: break-word; vertical-align: top;\" valign=\"top\">\n" +
                        "\t\t\t\t\t<!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td align=\"center\" style=\"background-color:#e2eace\"><![endif]-->\n" +
                        "\t\t\t\t\t<div style=\"background-color:transparent;\">\n" +
                        "\t\t\t\t\t\t<div class=\"block-grid \" style=\"Margin: 0 auto; min-width: 320px; max-width: 600px; overflow-wrap: break-word; word-wrap: break-word; word-break: break-word; background-color: transparent;\">\n" +
                        "\t\t\t\t\t\t\t<div style=\"border-collapse: collapse;display: table;width: 100%;background-color:transparent;\">\n" +
                        "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"background-color:transparent;\"><tr><td align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px\"><tr class=\"layout-full-width\" style=\"background-color:transparent\"><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]><td align=\"center\" width=\"600\" style=\"background-color:transparent;width:600px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top:5px; padding-bottom:0px;\"><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t<div class=\"col num12\" style=\"min-width: 320px; max-width: 600px; display: table-cell; vertical-align: top; width: 600px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t<div style=\"width:100% !important;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t<!--[if (!mso)&(!IE)]><!-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t<div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:5px; padding-bottom:0px; padding-right: 0px; padding-left: 0px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<!--<![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<div class=\"img-container center autowidth\" align=\"center\" style=\"padding-right: 0px;padding-left: 0px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr style=\"line-height:0px\"><td style=\"padding-right: 0px;padding-left: 0px;\" align=\"center\"><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"font-size:1px;line-height:25px\">&nbsp;</div><img class=\"center autowidth\" align=\"center\" border=\"0\" src=\"https://d1oco4z2z1fhwp.cloudfront.net/templates/default/20/rounder-up.png\" alt=\"Image\" title=\"Image\" style=\"text-decoration: none; -ms-interpolation-mode: bicubic; border: 0; height: auto; width: 100%; max-width: 600px; display: block;\" width=\"600\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]></td></tr></table><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<!--[if (!mso)&(!IE)]><!-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t\t\t<!--<![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]></td></tr></table></td></tr></table><![endif]-->\n" +
                        "\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t<div style=\"background-color:transparent;\">\n" +
                        "\t\t\t\t\t\t<div class=\"block-grid \" style=\"Margin: 0 auto; min-width: 320px; max-width: 600px; overflow-wrap: break-word; word-wrap: break-word; word-break: break-word; background-color: #FFFFFF;\">\n" +
                        "\t\t\t\t\t\t\t<div style=\"border-collapse: collapse;display: table;width: 100%;background-color:#FFFFFF;\">\n" +
                        "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"background-color:transparent;\"><tr><td align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px\"><tr class=\"layout-full-width\" style=\"background-color:#FFFFFF\"><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]><td align=\"center\" width=\"600\" style=\"background-color:#FFFFFF;width:600px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top:5px; padding-bottom:5px;\"><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t<div class=\"col num12\" style=\"min-width: 320px; max-width: 600px; display: table-cell; vertical-align: top; width: 600px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t<div style=\"width:100% !important;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t<!--[if (!mso)&(!IE)]><!-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t<div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:5px; padding-bottom:5px; padding-right: 0px; padding-left: 0px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<!--<![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<div class=\"img-container center\" align=\"center\" style=\"padding-right: 0px;padding-left: 0px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr style=\"line-height:0px\"><td style=\"padding-right: 0px;padding-left: 0px;\" align=\"center\"><![endif]--><img class=\"center\" align=\"center\" border=\"0\" src=\"https://media.licdn.com/dms/image/C561BAQFvBoDlloIR4w/company-background_10000/0?e=2159024400&amp;v=beta&amp;t=vmTY91FoP8rQRgvgePKIao5DgLbbV3pGjlLfFwHIwwM\" alt=\"Image\" title=\"Image\" style=\"text-decoration: none; -ms-interpolation-mode: bicubic; border: 0; height: auto; width: 100%; max-width: 360px; display: block;\" width=\"360\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]></td></tr></table><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 10px; padding-left: 10px; padding-top: 10px; padding-bottom: 10px; font-family: Tahoma, sans-serif\"><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<div style=\"color:#555555;font-family:Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif;line-height:1.5;padding-top:10px;padding-right:10px;padding-bottom:10px;padding-left:10px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"font-size: 12px; line-height: 1.5; color: #555555; font-family: Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif; mso-line-height-alt: 18px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t<p style=\"font-size: 14px; line-height: 1.5; text-align: center; word-break: break-word; mso-line-height-alt: 21px; margin: 0;\">Công Ty Cổ Phần Công Nghệ Và Truyền Thông VIS</p>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]></td></tr></table><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<!--[if (!mso)&(!IE)]><!-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t\t\t<!--<![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]></td></tr></table></td></tr></table><![endif]-->\n" +
                        "\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t<div style=\"background-color:transparent;\">\n" +
                        "\t\t\t\t\t\t<div class=\"block-grid \" style=\"Margin: 0 auto; min-width: 320px; max-width: 600px; overflow-wrap: break-word; word-wrap: break-word; word-break: break-word; background-color: #FFFFFF;\">\n" +
                        "\t\t\t\t\t\t\t<div style=\"border-collapse: collapse;display: table;width: 100%;background-color:#FFFFFF;\">\n" +
                        "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"background-color:transparent;\"><tr><td align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px\"><tr class=\"layout-full-width\" style=\"background-color:#FFFFFF\"><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]><td align=\"center\" width=\"600\" style=\"background-color:#FFFFFF;width:600px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top:0px; padding-bottom:5px;\"><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t<div class=\"col num12\" style=\"min-width: 320px; max-width: 600px; display: table-cell; vertical-align: top; width: 600px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t<div style=\"width:100% !important;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t<!--[if (!mso)&(!IE)]><!-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t<div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:0px; padding-bottom:5px; padding-right: 0px; padding-left: 0px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<!--<![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 10px; padding-left: 10px; padding-top: 10px; padding-bottom: 10px; font-family: Tahoma, sans-serif\"><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<div style=\"color:#0D0D0D;font-family:Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif;line-height:1.2;padding-top:10px;padding-right:10px;padding-bottom:10px;padding-left:10px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"font-size: 12px; line-height: 1.2; color: #0D0D0D; font-family: Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif; mso-line-height-alt: 14px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t<p style=\"font-size: 28px; line-height: 1.2; text-align: center; word-break: break-word; mso-line-height-alt: 34px; margin: 0;\"><span style=\"font-size: 28px;\"><strong>Thông báo nghỉ phép</strong></span></p>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]></td></tr></table><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<div class=\"img-container center\" align=\"center\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr style=\"line-height:0px\"><td style=\"\" align=\"center\"><![endif]--><img class=\"center\" align=\"center\" border=\"0\" src=\"https://d1oco4z2z1fhwp.cloudfront.net/templates/default/20/divider.png\" alt=\"Image\" title=\"Image\" style=\"text-decoration: none; -ms-interpolation-mode: bicubic; border: 0; height: auto; width: 100%; max-width: 318px; display: block;\" width=\"318\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]></td></tr></table><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 10px; padding-left: 10px; padding-top: 10px; padding-bottom: 10px; font-family: Tahoma, sans-serif\"><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<div style=\"color:#555555;font-family:Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif;line-height:1.5;padding-top:10px;padding-right:10px;padding-bottom:10px;padding-left:10px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"font-size: 12px; line-height: 1.5; color: #555555; font-family: Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif; mso-line-height-alt: 18px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t<p style=\"font-size: 14px; line-height: 1.5; text-align: center; word-break: break-word; mso-line-height-alt: 21px; margin: 0;\"><span style=\"color: #a8bf6f; font-size: 14px;\"><strong>Chào anh/chị!</strong></span></p>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t<p style=\"font-size: 14px; line-height: 1.5; text-align: center; word-break: break-word; mso-line-height-alt: 21px; margin: 0;\"><span style=\"color: #a8bf6f; font-size: 14px;\"><strong>Có một đơn xin nghỉ được gửi cho anh chị.</strong></span></p>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]></td></tr></table><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 10px; padding-left: 10px; padding-top: 20px; padding-bottom: 10px; font-family: Tahoma, sans-serif\"><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<div style=\"color:#0D0D0D;font-family:Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif;line-height:1.5;padding-top:20px;padding-right:10px;padding-bottom:10px;padding-left:10px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"line-height: 1.5; font-size: 12px; color: #0D0D0D; font-family: Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif; mso-line-height-alt: 18px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t<p style=\"line-height: 1.5; word-break: break-word; font-size: 14px; mso-line-height-alt: 21px; margin: 0;\"><span style=\"font-size: 14px;\">Thông tin chi tiết:</span></p>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t<p style=\"line-height: 1.5; word-break: break-word; font-size: 14px; mso-line-height-alt: 21px; margin: 0;\"><span style=\"font-size: 14px;\">Người gửi:<strong> "+ username +" (" +fullName+")" + "&nbsp;</strong></span></p>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t<p style=\"line-height: 1.5; word-break: break-word; font-size: 14px; mso-line-height-alt: 21px; margin: 0;\"><span style=\"font-size: 14px;\">Người duyệt:<strong> "+ approver +" (" + approverName +")"+ "&nbsp;</strong></span></p>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t<p style=\"line-height: 1.5; word-break: break-word; font-size: 14px; mso-line-height-alt: 21px; margin: 0;\"><span style=\"font-size: 14px;\">Quản lí trên một cấp:<strong> "+ managerLv2 + "&nbsp;</strong></span></p>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t<p style=\"line-height: 1.5; word-break: break-word; font-size: 14px; mso-line-height-alt: 21px; margin: 0;\"><span style=\"font-size: 14px;\"> "+ reasonName +" với lý do: <strong>"+ description +"</strong></span></p>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t<p style=\"line-height: 1.5; word-break: break-word; font-size: 14px; mso-line-height-alt: 21px; margin: 0;\"><span style=\"font-size: 14px;\">Ngày bắt đầu nghỉ:<strong> "+dateBegin+"</strong></span></p>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t<p style=\"line-height: 1.5; word-break: break-word; font-size: 14px; mso-line-height-alt: 21px; margin: 0;\"><span style=\"font-size: 14px;\">Ngày kết thúc nghỉ:<strong> "+dateEnd+"</strong></span></p>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]></td></tr></table><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<div class=\"button-container\" align=\"center\" style=\"padding-top:25px;padding-right:10px;padding-bottom:10px;padding-left:10px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"border-spacing: 0; border-collapse: collapse; mso-table-lspace:0pt; mso-table-rspace:0pt;\"><tr><td style=\"padding-top: 25px; padding-right: 10px; padding-bottom: 10px; padding-left: 10px\" align=\"center\"><v:roundrect xmlns:v=\"urn:schemas-microsoft-com:vml\" xmlns:w=\"urn:schemas-microsoft-com:office:word\" href=\"http://14.225.5.246:8864/#/timeoff-management\" style=\"height:46.5pt; width:100.5pt; v-text-anchor:middle;\" arcsize=\"7%\" stroke=\"false\" fillcolor=\"#a8bf6f\"><w:anchorlock/><v:textbox inset=\"0,0,0,0\"><center style=\"color:#ffffff; font-family:Tahoma, sans-serif; font-size:16px\"><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t<a href=\"http://14.225.5.246:8864/#/timeoff-management\" target=\"_blank\" style=\"-webkit-text-size-adjust: none; text-decoration: none; display: inline-block; color: #ffffff; background-color: #a8bf6f; border-radius: 4px; -webkit-border-radius: 4px; -moz-border-radius: 4px; width: auto; width: auto; border-top: 1px solid #a8bf6f; border-right: 1px solid #a8bf6f; border-bottom: 1px solid #a8bf6f; border-left: 1px solid #a8bf6f; padding-top: 15px; padding-bottom: 15px; font-family: Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif; text-align: center; mso-border-alt: none; word-break: keep-all;\"><span style=\"padding-left:15px;padding-right:15px;font-size:16px;display:inline-block;\"><span style=\"font-size: 16px; line-height: 2; word-break: break-word; mso-line-height-alt: 32px;\">Duyệt đơn xin nghỉ</span></span></a>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]></center></v:textbox></v:roundrect></td></tr></table><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<table class=\"divider\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;\" role=\"presentation\" valign=\"top\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t<tbody>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t<tr style=\"vertical-align: top;\" valign=\"top\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"divider_inner\" style=\"word-break: break-word; vertical-align: top; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%; padding-top: 30px; padding-right: 10px; padding-bottom: 10px; padding-left: 10px;\" valign=\"top\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<table class=\"divider_content\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-top: 0px solid transparent; width: 100%;\" align=\"center\" role=\"presentation\" valign=\"top\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tbody>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr style=\"vertical-align: top;\" valign=\"top\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td style=\"word-break: break-word; vertical-align: top; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;\" valign=\"top\"><span></span></td>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tbody>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</table>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t</tbody>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t</table>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<!--[if (!mso)&(!IE)]><!-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t\t\t<!--<![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]></td></tr></table></td></tr></table><![endif]-->\n" +
                        "\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t<div style=\"background-color:transparent;\">\n" +
                        "\t\t\t\t\t\t<div class=\"block-grid three-up\" style=\"Margin: 0 auto; min-width: 320px; max-width: 600px; overflow-wrap: break-word; word-wrap: break-word; word-break: break-word; background-color: #525252;\">\n" +
                        "\t\t\t\t\t\t\t<div style=\"border-collapse: collapse;display: table;width: 100%;background-color:#525252;\">\n" +
                        "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"background-color:transparent;\"><tr><td align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px\"><tr class=\"layout-full-width\" style=\"background-color:#525252\"><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]><td align=\"center\" width=\"200\" style=\"background-color:#525252;width:200px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top:0px; padding-bottom:0px;\"><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t<div class=\"col num4\" style=\"max-width: 320px; min-width: 200px; display: table-cell; vertical-align: top; width: 200px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t<div style=\"width:100% !important;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t<!--[if (!mso)&(!IE)]><!-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t<div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:0px; padding-bottom:0px; padding-right: 0px; padding-left: 0px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<!--<![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<table class=\"social_icons\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" role=\"presentation\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" valign=\"top\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t<tbody>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t<tr style=\"vertical-align: top;\" valign=\"top\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td style=\"word-break: break-word; vertical-align: top; padding-top: 15px; padding-right: 0px; padding-bottom: 0px; padding-left: 0px;\" valign=\"top\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<table class=\"social_table\" align=\"center\" to=\"to\" activate=\"activate\" alignment=\"alignment\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: undefined; mso-table-tspace: 0; mso-table-rspace: 0; mso-table-bspace: 0; mso-table-lspace: 0;\" valign=\"top\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tbody>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr style=\"vertical-align: top; display: inline-block; text-align: center;\" align=\"center\" valign=\"top\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td style=\"word-break: break-word; vertical-align: top; padding-bottom: 5px; padding-right: 3px; padding-left: 3px;\" valign=\"top\"><a href=\"http://vissoft.vn\" target=\"_blank\"><img width=\"32\" height=\"32\" src=\"https://d2fi4ri5dhpqd1.cloudfront.net/public/resources/social-networks-icon-sets/t-only-logo-default-gray/facebook@2x.png\" alt=\"Facebook\" title=\"Facebook\" style=\"text-decoration: none; -ms-interpolation-mode: bicubic; height: auto; border: none; display: block;\"></a></td>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td style=\"word-break: break-word; vertical-align: top; padding-bottom: 5px; padding-right: 3px; padding-left: 3px;\" valign=\"top\"><a href=\"http://vissoft.vn\" target=\"_blank\"><img width=\"32\" height=\"32\" src=\"https://d2fi4ri5dhpqd1.cloudfront.net/public/resources/social-networks-icon-sets/t-only-logo-default-gray/twitter@2x.png\" alt=\"Twitter\" title=\"Twitter\" style=\"text-decoration: none; -ms-interpolation-mode: bicubic; height: auto; border: none; display: block;\"></a></td>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td style=\"word-break: break-word; vertical-align: top; padding-bottom: 5px; padding-right: 3px; padding-left: 3px;\" valign=\"top\"><a href=\"http://vissoft.vn\" target=\"_blank\"><img width=\"32\" height=\"32\" src=\"https://d2fi4ri5dhpqd1.cloudfront.net/public/resources/social-networks-icon-sets/t-only-logo-default-gray/googleplus@2x.png\" alt=\"Google+\" title=\"Google+\" style=\"text-decoration: none; -ms-interpolation-mode: bicubic; height: auto; border: none; display: block;\"></a></td>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tbody>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</table>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t</tbody>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t</table>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<!--[if (!mso)&(!IE)]><!-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t\t\t<!--<![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]></td><td align=\"center\" width=\"200\" style=\"background-color:#525252;width:200px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top:5px; padding-bottom:5px;\"><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t<div class=\"col num4\" style=\"max-width: 320px; min-width: 200px; display: table-cell; vertical-align: top; width: 200px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t<div style=\"width:100% !important;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t<!--[if (!mso)&(!IE)]><!-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t<div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:5px; padding-bottom:5px; padding-right: 0px; padding-left: 0px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<!--<![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top: 20px; padding-bottom: 0px; font-family: Tahoma, sans-serif\"><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<div style=\"color:#a8bf6f;font-family:Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif;line-height:1.2;padding-top:20px;padding-right:0px;padding-bottom:0px;padding-left:0px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"font-size: 12px; line-height: 1.2; color: #a8bf6f; font-family: Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif; mso-line-height-alt: 14px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t<p style=\"font-size: 12px; line-height: 1.2; text-align: center; word-break: break-word; mso-line-height-alt: 14px; margin: 0;\"><span style=\"color: #ffffff; font-size: 12px;\"><span style=\"font-size: 12px; color: #a8bf6f;\">Tel.:</span> +(024) - 666 20346</span></p>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]></td></tr></table><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<!--[if (!mso)&(!IE)]><!-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t\t\t<!--<![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]></td><td align=\"center\" width=\"200\" style=\"background-color:#525252;width:200px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top:5px; padding-bottom:5px;\"><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t<div class=\"col num4\" style=\"max-width: 320px; min-width: 200px; display: table-cell; vertical-align: top; width: 200px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t<div style=\"width:100% !important;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t<!--[if (!mso)&(!IE)]><!-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t<div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:5px; padding-bottom:5px; padding-right: 0px; padding-left: 0px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<!--<![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top: 20px; padding-bottom: 0px; font-family: Tahoma, sans-serif\"><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<div style=\"color:#a8bf6f;font-family:Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif;line-height:1.2;padding-top:20px;padding-right:0px;padding-bottom:0px;padding-left:0px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"font-size: 12px; line-height: 1.2; color: #a8bf6f; font-family: Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif; mso-line-height-alt: 14px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t<p style=\"font-size: 12px; line-height: 1.2; text-align: center; word-break: break-word; mso-line-height-alt: 14px; margin: 0;\">Email <span style=\"color: #ffffff; font-size: 12px;\">contact@vissoft.vn</span></p>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]></td></tr></table><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<!--[if (!mso)&(!IE)]><!-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t\t\t<!--<![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]></td></tr></table></td></tr></table><![endif]-->\n" +
                        "\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t<div style=\"background-color:transparent;\">\n" +
                        "\t\t\t\t\t\t<div class=\"block-grid \" style=\"Margin: 0 auto; min-width: 320px; max-width: 600px; overflow-wrap: break-word; word-wrap: break-word; word-break: break-word; background-color: transparent;\">\n" +
                        "\t\t\t\t\t\t\t<div style=\"border-collapse: collapse;display: table;width: 100%;background-color:transparent;\">\n" +
                        "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"background-color:transparent;\"><tr><td align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px\"><tr class=\"layout-full-width\" style=\"background-color:transparent\"><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]><td align=\"center\" width=\"600\" style=\"background-color:transparent;width:600px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top:0px; padding-bottom:5px;\"><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t<div class=\"col num12\" style=\"min-width: 320px; max-width: 600px; display: table-cell; vertical-align: top; width: 600px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t<div style=\"width:100% !important;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t<!--[if (!mso)&(!IE)]><!-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t<div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:0px; padding-bottom:5px; padding-right: 0px; padding-left: 0px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<!--<![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<div class=\"img-container center autowidth\" align=\"center\" style=\"padding-right: 0px;padding-left: 0px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr style=\"line-height:0px\"><td style=\"padding-right: 0px;padding-left: 0px;\" align=\"center\"><![endif]--><img class=\"center autowidth\" align=\"center\" border=\"0\" src=\"https://d1oco4z2z1fhwp.cloudfront.net/templates/default/20/rounder-dwn.png\" alt=\"Image\" title=\"Image\" style=\"text-decoration: none; -ms-interpolation-mode: bicubic; border: 0; height: auto; width: 100%; max-width: 600px; display: block;\" width=\"600\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]></td></tr></table><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<table class=\"divider\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;\" role=\"presentation\" valign=\"top\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t<tbody>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t<tr style=\"vertical-align: top;\" valign=\"top\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"divider_inner\" style=\"word-break: break-word; vertical-align: top; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%; padding-top: 30px; padding-right: 30px; padding-bottom: 30px; padding-left: 30px;\" valign=\"top\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<table class=\"divider_content\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-top: 0px solid transparent; width: 100%;\" align=\"center\" role=\"presentation\" valign=\"top\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tbody>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr style=\"vertical-align: top;\" valign=\"top\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td style=\"word-break: break-word; vertical-align: top; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;\" valign=\"top\"><span></span></td>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tbody>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</table>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t</tbody>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t</table>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<!--[if (!mso)&(!IE)]><!-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t\t\t<!--<![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]></td></tr></table></td></tr></table><![endif]-->\n" +
                        "\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n" +
                        "\t\t\t\t</td>\n" +
                        "\t\t\t</tr>\n" +
                        "\t\t</tbody>\n" +
                        "\t</table>\n" +
                        "\t<!--[if (IE)]></div><![endif]-->\n" +
                        "</body>\n" +
                        "\n" +
                        "</html>";
        return emailContent;


    }

    @Override
    public String emailSendToUser(String sender,
                                  String approver,
                                  String receiver,
                                  String managerLv2,
                                  String reason,
                                  String approverDate,
                                  String dateBegin,
                                  String dateEnd,
                                  Integer status,
                                  String description,
                                  String reasonReject) {

        String cssStatus;
        String contentStatus;

        if (status == 1) {
            cssStatus = "style =\"color:green;\" ";
            contentStatus = "Đồng ý";

            String emailContentApproved =
                    "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional //EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
                            "<html xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:v=\"urn:schemas-microsoft-com:vml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\">\n" +
                            "\n" +
                            "<head>\n" +
                            "\t<!--[if gte mso 9]><xml><o:OfficeDocumentSettings><o:AllowPNG/><o:PixelsPerInch>96</o:PixelsPerInch></o:OfficeDocumentSettings></xml><![endif]-->\n" +
                            "\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\n" +
                            "\t<meta name=\"viewport\" content=\"width=device-width\">\n" +
                            "\t<!--[if !mso]><!-->\n" +
                            "\t<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
                            "\t<!--<![endif]-->\n" +
                            "\t<title></title>\n" +
                            "\t<!--[if !mso]><!-->\n" +
                            "\t<link href=\"https://fonts.googleapis.com/css?family=Montserrat\" rel=\"stylesheet\" type=\"text/css\">\n" +
                            "\t<!--<![endif]-->\n" +
                            "\t<style type=\"text/css\">\n" +
                            "\t\tbody {\n" +
                            "\t\t\tmargin: 0;\n" +
                            "\t\t\tpadding: 0;\n" +
                            "\t\t}\n" +
                            "\n" +
                            "\t\ttable,\n" +
                            "\t\ttd,\n" +
                            "\t\ttr {\n" +
                            "\t\t\tvertical-align: top;\n" +
                            "\t\t\tborder-collapse: collapse;\n" +
                            "\t\t}\n" +
                            "\n" +
                            "\t\t* {\n" +
                            "\t\t\tline-height: inherit;\n" +
                            "\t\t}\n" +
                            "\n" +
                            "\t\ta[x-apple-data-detectors=true] {\n" +
                            "\t\t\tcolor: inherit !important;\n" +
                            "\t\t\ttext-decoration: none !important;\n" +
                            "\t\t}\n" +
                            "\t</style>\n" +
                            "\t<style type=\"text/css\" id=\"media-query\">\n" +
                            "\t\t@media (max-width: 620px) {\n" +
                            "\n" +
                            "\t\t\t.block-grid,\n" +
                            "\t\t\t.col {\n" +
                            "\t\t\t\tmin-width: 320px !important;\n" +
                            "\t\t\t\tmax-width: 100% !important;\n" +
                            "\t\t\t\tdisplay: block !important;\n" +
                            "\t\t\t}\n" +
                            "\n" +
                            "\t\t\t.block-grid {\n" +
                            "\t\t\t\twidth: 100% !important;\n" +
                            "\t\t\t}\n" +
                            "\n" +
                            "\t\t\t.col {\n" +
                            "\t\t\t\twidth: 100% !important;\n" +
                            "\t\t\t}\n" +
                            "\n" +
                            "\t\t\t.col>div {\n" +
                            "\t\t\t\tmargin: 0 auto;\n" +
                            "\t\t\t}\n" +
                            "\n" +
                            "\t\t\timg.fullwidth,\n" +
                            "\t\t\timg.fullwidthOnMobile {\n" +
                            "\t\t\t\tmax-width: 100% !important;\n" +
                            "\t\t\t}\n" +
                            "\n" +
                            "\t\t\t.no-stack .col {\n" +
                            "\t\t\t\tmin-width: 0 !important;\n" +
                            "\t\t\t\tdisplay: table-cell !important;\n" +
                            "\t\t\t}\n" +
                            "\n" +
                            "\t\t\t.no-stack.two-up .col {\n" +
                            "\t\t\t\twidth: 50% !important;\n" +
                            "\t\t\t}\n" +
                            "\n" +
                            "\t\t\t.no-stack .col.num4 {\n" +
                            "\t\t\t\twidth: 33% !important;\n" +
                            "\t\t\t}\n" +
                            "\n" +
                            "\t\t\t.no-stack .col.num8 {\n" +
                            "\t\t\t\twidth: 66% !important;\n" +
                            "\t\t\t}\n" +
                            "\n" +
                            "\t\t\t.no-stack .col.num4 {\n" +
                            "\t\t\t\twidth: 33% !important;\n" +
                            "\t\t\t}\n" +
                            "\n" +
                            "\t\t\t.no-stack .col.num3 {\n" +
                            "\t\t\t\twidth: 25% !important;\n" +
                            "\t\t\t}\n" +
                            "\n" +
                            "\t\t\t.no-stack .col.num6 {\n" +
                            "\t\t\t\twidth: 50% !important;\n" +
                            "\t\t\t}\n" +
                            "\n" +
                            "\t\t\t.no-stack .col.num9 {\n" +
                            "\t\t\t\twidth: 75% !important;\n" +
                            "\t\t\t}\n" +
                            "\n" +
                            "\t\t\t.video-block {\n" +
                            "\t\t\t\tmax-width: none !important;\n" +
                            "\t\t\t}\n" +
                            "\n" +
                            "\t\t\t.mobile_hide {\n" +
                            "\t\t\t\tmin-height: 0px;\n" +
                            "\t\t\t\tmax-height: 0px;\n" +
                            "\t\t\t\tmax-width: 0px;\n" +
                            "\t\t\t\tdisplay: none;\n" +
                            "\t\t\t\toverflow: hidden;\n" +
                            "\t\t\t\tfont-size: 0px;\n" +
                            "\t\t\t}\n" +
                            "\n" +
                            "\t\t\t.desktop_hide {\n" +
                            "\t\t\t\tdisplay: block !important;\n" +
                            "\t\t\t\tmax-height: none !important;\n" +
                            "\t\t\t}\n" +
                            "\t\t}\n" +
                            "\t</style>\n" +
                            "</head>\n" +
                            "\n" +
                            "<body class=\"clean-body\" style=\"margin: 0; padding: 0; -webkit-text-size-adjust: 100%; background-color: #e2eace;\">\n" +
                            "\t<!--[if IE]><div class=\"ie-browser\"><![endif]-->\n" +
                            "\t<table class=\"nl-container\" style=\"table-layout: fixed; vertical-align: top; min-width: 320px; Margin: 0 auto; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #e2eace; width: 100%;\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" width=\"100%\" bgcolor=\"#e2eace\" valign=\"top\">\n" +
                            "\t\t<tbody>\n" +
                            "\t\t\t<tr style=\"vertical-align: top;\" valign=\"top\">\n" +
                            "\t\t\t\t<td style=\"word-break: break-word; vertical-align: top;\" valign=\"top\">\n" +
                            "\t\t\t\t\t<!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td align=\"center\" style=\"background-color:#e2eace\"><![endif]-->\n" +
                            "\t\t\t\t\t<div style=\"background-color:transparent;\">\n" +
                            "\t\t\t\t\t\t<div class=\"block-grid \" style=\"Margin: 0 auto; min-width: 320px; max-width: 600px; overflow-wrap: break-word; word-wrap: break-word; word-break: break-word; background-color: transparent;\">\n" +
                            "\t\t\t\t\t\t\t<div style=\"border-collapse: collapse;display: table;width: 100%;background-color:transparent;\">\n" +
                            "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"background-color:transparent;\"><tr><td align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px\"><tr class=\"layout-full-width\" style=\"background-color:transparent\"><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]><td align=\"center\" width=\"600\" style=\"background-color:transparent;width:600px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top:5px; padding-bottom:0px;\"><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t<div class=\"col num12\" style=\"min-width: 320px; max-width: 600px; display: table-cell; vertical-align: top; width: 600px;\">\n" +
                            "\t\t\t\t\t\t\t\t\t<div style=\"width:100% !important;\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t<!--[if (!mso)&(!IE)]><!-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t<div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:5px; padding-bottom:0px; padding-right: 0px; padding-left: 0px;\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<!--<![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<div class=\"img-container center autowidth\" align=\"center\" style=\"padding-right: 0px;padding-left: 0px;\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr style=\"line-height:0px\"><td style=\"padding-right: 0px;padding-left: 0px;\" align=\"center\"><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"font-size:1px;line-height:25px\">&nbsp;</div><img class=\"center autowidth\" align=\"center\" border=\"0\" src=\"https://d1oco4z2z1fhwp.cloudfront.net/templates/default/20/rounder-up.png\" alt=\"Image\" title=\"Image\" style=\"text-decoration: none; -ms-interpolation-mode: bicubic; border: 0; height: auto; width: 100%; max-width: 600px; display: block;\" width=\"600\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]></td></tr></table><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<!--[if (!mso)&(!IE)]><!-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t\t\t<!--<![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]></td></tr></table></td></tr></table><![endif]-->\n" +
                            "\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t<div style=\"background-color:transparent;\">\n" +
                            "\t\t\t\t\t\t<div class=\"block-grid \" style=\"Margin: 0 auto; min-width: 320px; max-width: 600px; overflow-wrap: break-word; word-wrap: break-word; word-break: break-word; background-color: #FFFFFF;\">\n" +
                            "\t\t\t\t\t\t\t<div style=\"border-collapse: collapse;display: table;width: 100%;background-color:#FFFFFF;\">\n" +
                            "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"background-color:transparent;\"><tr><td align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px\"><tr class=\"layout-full-width\" style=\"background-color:#FFFFFF\"><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]><td align=\"center\" width=\"600\" style=\"background-color:#FFFFFF;width:600px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top:5px; padding-bottom:5px;\"><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t<div class=\"col num12\" style=\"min-width: 320px; max-width: 600px; display: table-cell; vertical-align: top; width: 600px;\">\n" +
                            "\t\t\t\t\t\t\t\t\t<div style=\"width:100% !important;\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t<!--[if (!mso)&(!IE)]><!-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t<div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:5px; padding-bottom:5px; padding-right: 0px; padding-left: 0px;\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<!--<![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<div class=\"img-container center\" align=\"center\" style=\"padding-right: 0px;padding-left: 0px;\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr style=\"line-height:0px\"><td style=\"padding-right: 0px;padding-left: 0px;\" align=\"center\"><![endif]--><img class=\"center\" align=\"center\" border=\"0\" src=\"https://cdn.itviec.com/employers/vis-soft/logo/social/DXErnqbxaE5NmyzrCp8EBBYG/vis-soft-logo.png\" alt=\"Image\" title=\"Image\" style=\"text-decoration: none; -ms-interpolation-mode: bicubic; border: 0; height: auto; width: 100%; max-width: 150px; display: block;\" width=\"150\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]></td></tr></table><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 10px; padding-left: 10px; padding-top: 10px; padding-bottom: 10px; font-family: Tahoma, sans-serif\"><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<div style=\"color:#555555;font-family:Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif;line-height:1.5;padding-top:10px;padding-right:10px;padding-bottom:10px;padding-left:10px;\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"font-size: 12px; line-height: 1.5; color: #555555; font-family: Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif; mso-line-height-alt: 18px;\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t<p style=\"font-size: 14px; line-height: 1.5; text-align: center; word-break: break-word; mso-line-height-alt: 21px; margin: 0;\">Công ty Cổ Phần Công Nghệ Và Truyền Thông VIS</p>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]></td></tr></table><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<!--[if (!mso)&(!IE)]><!-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t\t\t<!--<![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]></td></tr></table></td></tr></table><![endif]-->\n" +
                            "\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t<div style=\"background-color:transparent;\">\n" +
                            "\t\t\t\t\t\t<div class=\"block-grid \" style=\"Margin: 0 auto; min-width: 320px; max-width: 600px; overflow-wrap: break-word; word-wrap: break-word; word-break: break-word; background-color: #FFFFFF;\">\n" +
                            "\t\t\t\t\t\t\t<div style=\"border-collapse: collapse;display: table;width: 100%;background-color:#FFFFFF;\">\n" +
                            "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"background-color:transparent;\"><tr><td align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px\"><tr class=\"layout-full-width\" style=\"background-color:#FFFFFF\"><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]><td align=\"center\" width=\"600\" style=\"background-color:#FFFFFF;width:600px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top:0px; padding-bottom:5px;\"><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t<div class=\"col num12\" style=\"min-width: 320px; max-width: 600px; display: table-cell; vertical-align: top; width: 600px;\">\n" +
                            "\t\t\t\t\t\t\t\t\t<div style=\"width:100% !important;\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t<!--[if (!mso)&(!IE)]><!-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t<div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:0px; padding-bottom:5px; padding-right: 0px; padding-left: 0px;\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<!--<![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 10px; padding-left: 10px; padding-top: 10px; padding-bottom: 10px; font-family: Tahoma, sans-serif\"><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<div style=\"color:#0D0D0D;font-family:Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif;line-height:1.2;padding-top:10px;padding-right:10px;padding-bottom:10px;padding-left:10px;\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"font-size: 12px; line-height: 1.2; color: #0D0D0D; font-family: Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif; mso-line-height-alt: 14px;\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t<p style=\"font-size: 28px; line-height: 1.2; text-align: center; word-break: break-word; mso-line-height-alt: 34px; margin: 0;\"><span style=\"font-size: 28px;\"><strong>Thông báo nghỉ phép</strong></span></p>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]></td></tr></table><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<div class=\"img-container center\" align=\"center\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr style=\"line-height:0px\"><td style=\"\" align=\"center\"><![endif]--><img class=\"center\" align=\"center\" border=\"0\" src=\"https://d1oco4z2z1fhwp.cloudfront.net/templates/default/20/divider.png\" alt=\"Image\" title=\"Image\" style=\"text-decoration: none; -ms-interpolation-mode: bicubic; border: 0; height: auto; width: 100%; max-width: 318px; display: block;\" width=\"318\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]></td></tr></table><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 10px; padding-left: 10px; padding-top: 10px; padding-bottom: 10px; font-family: Tahoma, sans-serif\"><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<div style=\"color:#555555;font-family:Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif;line-height:1.5;padding-top:10px;padding-right:10px;padding-bottom:10px;padding-left:10px;\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"font-size: 12px; line-height: 1.5; color: #555555; font-family: Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif; mso-line-height-alt: 18px;\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t<p style=\"font-size: 14px; line-height: 1.5; text-align: center; word-break: break-word; mso-line-height-alt: 21px; margin: 0;\"><span style=\"color: #a8bf6f; font-size: 14px;\"><strong>Đơn xin nghỉ phép của " +sender+ " đã được "+approver+" duyệt</strong></span></p>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]></td></tr></table><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 10px; padding-left: 10px; padding-top: 20px; padding-bottom: 10px; font-family: Tahoma, sans-serif\"><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<div style=\"color:#0D0D0D;font-family:Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif;line-height:1.5;padding-top:20px;padding-right:10px;padding-bottom:10px;padding-left:10px;\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"line-height: 1.5; font-size: 12px; color: #0D0D0D; font-family: Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif; mso-line-height-alt: 18px;\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t<p style=\"line-height: 1.5; word-break: break-word; font-size: 14px; mso-line-height-alt: 21px; margin: 0;\"><span style=\"font-size: 14px;\"><strong>Thông tin chi tiết:</strong></span></p>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t<p style=\"line-height: 1.5; word-break: break-word; font-size: 14px; mso-line-height-alt: 21px; margin: 0;\"><span style=\"font-size: 14px;\">Người gửi: <strong>"+sender+"</strong></span></p>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t<p style=\"line-height: 1.5; word-break: break-word; font-size: 14px; mso-line-height-alt: 21px; margin: 0;\"><span style=\"font-size: 14px;\">Người duyệt: <strong>"+approver+"</strong></span></p>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t<p style=\"line-height: 1.5; word-break: break-word; font-size: 14px; mso-line-height-alt: 21px; margin: 0;\"><span style=\"font-size: 14px;\">Quản lí trên một cấp: <strong>"+managerLv2+"</strong></span></p>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t<p style=\"line-height: 1.5; word-break: break-word; font-size: 14px; mso-line-height-alt: 21px; margin: 0;\"><span style=\"font-size: 14px;\">Lý do:&nbsp;<strong>"+reason+"</strong></span></p>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t<p style=\"line-height: 1.5; word-break: break-word; font-size: 14px; mso-line-height-alt: 21px; margin: 0;\"><span style=\"font-size: 14px;\">Miêu tả<strong>: "+description+"</strong></span></p>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t<p style=\"line-height: 1.5; word-break: break-word; font-size: 14px; mso-line-height-alt: 21px; margin: 0;\"><span style=\"font-size: 14px;\">Ngày duyệt:<strong> "+approverDate+"</strong></span></p>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t<p style=\"line-height: 1.5; word-break: break-word; font-size: 14px; mso-line-height-alt: 21px; margin: 0;\"><span style=\"font-size: 14px;\">Ngày bắt đầu nghỉ:<strong> "+dateBegin+"</strong></span></p>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t<p style=\"line-height: 1.5; word-break: break-word; font-size: 14px; mso-line-height-alt: 21px; margin: 0;\"><span style=\"font-size: 14px;\">Ngày kết thúc nghỉ:<strong> "+dateEnd+"</strong></span></p>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t<p style=\"line-height: 1.5; word-break: break-word; font-size: 14px; mso-line-height-alt: 21px; margin: 0;\"><span "+cssStatus+" >Trạng thái:<strong> "+contentStatus+"</strong></span></p>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t<p style=\"line-height: 1.5; word-break: break-word; font-size: 14px; mso-line-height-alt: 21px; margin: 0;\"><span style=\"font-size: 14px;\" >Ghi chú:<strong> "+reasonReject+"</strong></span></p>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t<p style=\"line-height: 1.5; word-break: break-word; mso-line-height-alt: NaNpx; margin: 0;\">&nbsp;</p>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t<p style=\"line-height: 1.5; word-break: break-word; font-size: 14px; mso-line-height-alt: 21px; margin: 0;\"><span style=\"font-size: 14px;\"><strong>Xin cảm ơn!</strong></span></p>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]></td></tr></table><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<table class=\"divider\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;\" role=\"presentation\" valign=\"top\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t<tbody>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t<tr style=\"vertical-align: top;\" valign=\"top\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"divider_inner\" style=\"word-break: break-word; vertical-align: top; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%; padding-top: 30px; padding-right: 10px; padding-bottom: 10px; padding-left: 10px;\" valign=\"top\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<table class=\"divider_content\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-top: 0px solid transparent; width: 100%;\" align=\"center\" role=\"presentation\" valign=\"top\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tbody>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr style=\"vertical-align: top;\" valign=\"top\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td style=\"word-break: break-word; vertical-align: top; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;\" valign=\"top\"><span></span></td>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tbody>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</table>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t</tbody>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t</table>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<!--[if (!mso)&(!IE)]><!-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t\t\t<!--<![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]></td></tr></table></td></tr></table><![endif]-->\n" +
                            "\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t<div style=\"background-color:transparent;\">\n" +
                            "\t\t\t\t\t\t<div class=\"block-grid three-up\" style=\"Margin: 0 auto; min-width: 320px; max-width: 600px; overflow-wrap: break-word; word-wrap: break-word; word-break: break-word; background-color: #525252;\">\n" +
                            "\t\t\t\t\t\t\t<div style=\"border-collapse: collapse;display: table;width: 100%;background-color:#525252;\">\n" +
                            "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"background-color:transparent;\"><tr><td align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px\"><tr class=\"layout-full-width\" style=\"background-color:#525252\"><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]><td align=\"center\" width=\"200\" style=\"background-color:#525252;width:200px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top:0px; padding-bottom:0px;\"><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t<div class=\"col num4\" style=\"max-width: 320px; min-width: 200px; display: table-cell; vertical-align: top; width: 200px;\">\n" +
                            "\t\t\t\t\t\t\t\t\t<div style=\"width:100% !important;\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t<!--[if (!mso)&(!IE)]><!-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t<div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:0px; padding-bottom:0px; padding-right: 0px; padding-left: 0px;\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<!--<![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<table class=\"social_icons\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" role=\"presentation\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" valign=\"top\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t<tbody>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t<tr style=\"vertical-align: top;\" valign=\"top\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td style=\"word-break: break-word; vertical-align: top; padding-top: 15px; padding-right: 0px; padding-bottom: 0px; padding-left: 0px;\" valign=\"top\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<table class=\"social_table\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-tspace: 0; mso-table-rspace: 0; mso-table-bspace: 0; mso-table-lspace: 0;\" valign=\"top\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tbody>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr style=\"vertical-align: top; display: inline-block; text-align: center;\" align=\"center\" valign=\"top\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td style=\"word-break: break-word; vertical-align: top; padding-bottom: 5px; padding-right: 3px; padding-left: 3px;\" valign=\"top\"><a href=\"https://www.facebook.com/\" target=\"_blank\"><img width=\"32\" height=\"32\" src=\"https://d2fi4ri5dhpqd1.cloudfront.net/public/resources/social-networks-icon-sets/t-only-logo-default-gray/facebook@2x.png\" alt=\"Facebook\" title=\"Facebook\" style=\"text-decoration: none; -ms-interpolation-mode: bicubic; height: auto; border: none; display: block;\"></a></td>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td style=\"word-break: break-word; vertical-align: top; padding-bottom: 5px; padding-right: 3px; padding-left: 3px;\" valign=\"top\"><a href=\"https://twitter.com/\" target=\"_blank\"><img width=\"32\" height=\"32\" src=\"https://d2fi4ri5dhpqd1.cloudfront.net/public/resources/social-networks-icon-sets/t-only-logo-default-gray/twitter@2x.png\" alt=\"Twitter\" title=\"Twitter\" style=\"text-decoration: none; -ms-interpolation-mode: bicubic; height: auto; border: none; display: block;\"></a></td>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td style=\"word-break: break-word; vertical-align: top; padding-bottom: 5px; padding-right: 3px; padding-left: 3px;\" valign=\"top\"><a href=\"https://plus.google.com/\" target=\"_blank\"><img width=\"32\" height=\"32\" src=\"https://d2fi4ri5dhpqd1.cloudfront.net/public/resources/social-networks-icon-sets/t-only-logo-default-gray/googleplus@2x.png\" alt=\"Google+\" title=\"Google+\" style=\"text-decoration: none; -ms-interpolation-mode: bicubic; height: auto; border: none; display: block;\"></a></td>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tbody>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</table>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t</tbody>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t</table>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<!--[if (!mso)&(!IE)]><!-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t\t\t<!--<![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]></td><td align=\"center\" width=\"200\" style=\"background-color:#525252;width:200px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top:5px; padding-bottom:5px;\"><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t<div class=\"col num4\" style=\"max-width: 320px; min-width: 200px; display: table-cell; vertical-align: top; width: 200px;\">\n" +
                            "\t\t\t\t\t\t\t\t\t<div style=\"width:100% !important;\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t<!--[if (!mso)&(!IE)]><!-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t<div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:5px; padding-bottom:5px; padding-right: 0px; padding-left: 0px;\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<!--<![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top: 20px; padding-bottom: 0px; font-family: Tahoma, sans-serif\"><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<div style=\"color:#a8bf6f;font-family:Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif;line-height:1.2;padding-top:20px;padding-right:0px;padding-bottom:0px;padding-left:0px;\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"font-size: 12px; line-height: 1.2; color: #a8bf6f; font-family: Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif; mso-line-height-alt: 14px;\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t<p style=\"font-size: 12px; line-height: 1.2; text-align: center; word-break: break-word; mso-line-height-alt: 14px; margin: 0;\"><span style=\"color: #ffffff; font-size: 12px;\"><span style=\"font-size: 12px; color: #a8bf6f;\">Tel.:</span> +(024) - 666 20346</span></p>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]></td></tr></table><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<!--[if (!mso)&(!IE)]><!-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t\t\t<!--<![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]></td><td align=\"center\" width=\"200\" style=\"background-color:#525252;width:200px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top:5px; padding-bottom:5px;\"><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t<div class=\"col num4\" style=\"max-width: 320px; min-width: 200px; display: table-cell; vertical-align: top; width: 200px;\">\n" +
                            "\t\t\t\t\t\t\t\t\t<div style=\"width:100% !important;\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t<!--[if (!mso)&(!IE)]><!-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t<div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:5px; padding-bottom:5px; padding-right: 0px; padding-left: 0px;\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<!--<![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top: 20px; padding-bottom: 0px; font-family: Tahoma, sans-serif\"><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<div style=\"color:#a8bf6f;font-family:Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif;line-height:1.2;padding-top:20px;padding-right:0px;padding-bottom:0px;padding-left:0px;\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"font-size: 12px; line-height: 1.2; color: #a8bf6f; font-family: Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif; mso-line-height-alt: 14px;\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t<p style=\"font-size: 12px; line-height: 1.2; text-align: center; word-break: break-word; mso-line-height-alt: 14px; margin: 0;\">Email&nbsp;<span style=\"color: #ffffff;\">Contact@vissoft.vn</span></p>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]></td></tr></table><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<!--[if (!mso)&(!IE)]><!-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t\t\t<!--<![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]></td></tr></table></td></tr></table><![endif]-->\n" +
                            "\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t<div style=\"background-color:transparent;\">\n" +
                            "\t\t\t\t\t\t<div class=\"block-grid \" style=\"Margin: 0 auto; min-width: 320px; max-width: 600px; overflow-wrap: break-word; word-wrap: break-word; word-break: break-word; background-color: transparent;\">\n" +
                            "\t\t\t\t\t\t\t<div style=\"border-collapse: collapse;display: table;width: 100%;background-color:transparent;\">\n" +
                            "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"background-color:transparent;\"><tr><td align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px\"><tr class=\"layout-full-width\" style=\"background-color:transparent\"><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]><td align=\"center\" width=\"600\" style=\"background-color:transparent;width:600px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top:0px; padding-bottom:5px;\"><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t<div class=\"col num12\" style=\"min-width: 320px; max-width: 600px; display: table-cell; vertical-align: top; width: 600px;\">\n" +
                            "\t\t\t\t\t\t\t\t\t<div style=\"width:100% !important;\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t<!--[if (!mso)&(!IE)]><!-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t<div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:0px; padding-bottom:5px; padding-right: 0px; padding-left: 0px;\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<!--<![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<div class=\"img-container center autowidth\" align=\"center\" style=\"padding-right: 0px;padding-left: 0px;\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr style=\"line-height:0px\"><td style=\"padding-right: 0px;padding-left: 0px;\" align=\"center\"><![endif]--><img class=\"center autowidth\" align=\"center\" border=\"0\" src=\"https://d1oco4z2z1fhwp.cloudfront.net/templates/default/20/rounder-dwn.png\" alt=\"Image\" title=\"Image\" style=\"text-decoration: none; -ms-interpolation-mode: bicubic; border: 0; height: auto; width: 100%; max-width: 600px; display: block;\" width=\"600\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]></td></tr></table><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<table class=\"divider\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;\" role=\"presentation\" valign=\"top\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t<tbody>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t<tr style=\"vertical-align: top;\" valign=\"top\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"divider_inner\" style=\"word-break: break-word; vertical-align: top; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%; padding-top: 30px; padding-right: 30px; padding-bottom: 30px; padding-left: 30px;\" valign=\"top\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<table class=\"divider_content\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-top: 0px solid transparent; width: 100%;\" align=\"center\" role=\"presentation\" valign=\"top\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tbody>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr style=\"vertical-align: top;\" valign=\"top\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td style=\"word-break: break-word; vertical-align: top; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;\" valign=\"top\"><span></span></td>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tbody>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</table>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t</tbody>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t</table>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<!--[if (!mso)&(!IE)]><!-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t\t\t<!--<![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]></td></tr></table></td></tr></table><![endif]-->\n" +
                            "\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n" +
                            "\t\t\t\t</td>\n" +
                            "\t\t\t</tr>\n" +
                            "\t\t</tbody>\n" +
                            "\t</table>\n" +
                            "\t<!--[if (IE)]></div><![endif]-->\n" +
                            "</body>\n" +
                            "\n" +
                            "</html>";
            return emailContentApproved;
        } else {
            cssStatus = "style =\"color:red;\" ";
            contentStatus = "Từ chối";

            String emailContentReject =
                    "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional //EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
                            "<html xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:v=\"urn:schemas-microsoft-com:vml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\">\n" +
                            "\n" +
                            "<head>\n" +
                            "\t<!--[if gte mso 9]><xml><o:OfficeDocumentSettings><o:AllowPNG/><o:PixelsPerInch>96</o:PixelsPerInch></o:OfficeDocumentSettings></xml><![endif]-->\n" +
                            "\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\n" +
                            "\t<meta name=\"viewport\" content=\"width=device-width\">\n" +
                            "\t<!--[if !mso]><!-->\n" +
                            "\t<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
                            "\t<!--<![endif]-->\n" +
                            "\t<title></title>\n" +
                            "\t<!--[if !mso]><!-->\n" +
                            "\t<link href=\"https://fonts.googleapis.com/css?family=Montserrat\" rel=\"stylesheet\" type=\"text/css\">\n" +
                            "\t<!--<![endif]-->\n" +
                            "\t<style type=\"text/css\">\n" +
                            "\t\tbody {\n" +
                            "\t\t\tmargin: 0;\n" +
                            "\t\t\tpadding: 0;\n" +
                            "\t\t}\n" +
                            "\n" +
                            "\t\ttable,\n" +
                            "\t\ttd,\n" +
                            "\t\ttr {\n" +
                            "\t\t\tvertical-align: top;\n" +
                            "\t\t\tborder-collapse: collapse;\n" +
                            "\t\t}\n" +
                            "\n" +
                            "\t\t* {\n" +
                            "\t\t\tline-height: inherit;\n" +
                            "\t\t}\n" +
                            "\n" +
                            "\t\ta[x-apple-data-detectors=true] {\n" +
                            "\t\t\tcolor: inherit !important;\n" +
                            "\t\t\ttext-decoration: none !important;\n" +
                            "\t\t}\n" +
                            "\t</style>\n" +
                            "\t<style type=\"text/css\" id=\"media-query\">\n" +
                            "\t\t@media (max-width: 620px) {\n" +
                            "\n" +
                            "\t\t\t.block-grid,\n" +
                            "\t\t\t.col {\n" +
                            "\t\t\t\tmin-width: 320px !important;\n" +
                            "\t\t\t\tmax-width: 100% !important;\n" +
                            "\t\t\t\tdisplay: block !important;\n" +
                            "\t\t\t}\n" +
                            "\n" +
                            "\t\t\t.block-grid {\n" +
                            "\t\t\t\twidth: 100% !important;\n" +
                            "\t\t\t}\n" +
                            "\n" +
                            "\t\t\t.col {\n" +
                            "\t\t\t\twidth: 100% !important;\n" +
                            "\t\t\t}\n" +
                            "\n" +
                            "\t\t\t.col>div {\n" +
                            "\t\t\t\tmargin: 0 auto;\n" +
                            "\t\t\t}\n" +
                            "\n" +
                            "\t\t\timg.fullwidth,\n" +
                            "\t\t\timg.fullwidthOnMobile {\n" +
                            "\t\t\t\tmax-width: 100% !important;\n" +
                            "\t\t\t}\n" +
                            "\n" +
                            "\t\t\t.no-stack .col {\n" +
                            "\t\t\t\tmin-width: 0 !important;\n" +
                            "\t\t\t\tdisplay: table-cell !important;\n" +
                            "\t\t\t}\n" +
                            "\n" +
                            "\t\t\t.no-stack.two-up .col {\n" +
                            "\t\t\t\twidth: 50% !important;\n" +
                            "\t\t\t}\n" +
                            "\n" +
                            "\t\t\t.no-stack .col.num4 {\n" +
                            "\t\t\t\twidth: 33% !important;\n" +
                            "\t\t\t}\n" +
                            "\n" +
                            "\t\t\t.no-stack .col.num8 {\n" +
                            "\t\t\t\twidth: 66% !important;\n" +
                            "\t\t\t}\n" +
                            "\n" +
                            "\t\t\t.no-stack .col.num4 {\n" +
                            "\t\t\t\twidth: 33% !important;\n" +
                            "\t\t\t}\n" +
                            "\n" +
                            "\t\t\t.no-stack .col.num3 {\n" +
                            "\t\t\t\twidth: 25% !important;\n" +
                            "\t\t\t}\n" +
                            "\n" +
                            "\t\t\t.no-stack .col.num6 {\n" +
                            "\t\t\t\twidth: 50% !important;\n" +
                            "\t\t\t}\n" +
                            "\n" +
                            "\t\t\t.no-stack .col.num9 {\n" +
                            "\t\t\t\twidth: 75% !important;\n" +
                            "\t\t\t}\n" +
                            "\n" +
                            "\t\t\t.video-block {\n" +
                            "\t\t\t\tmax-width: none !important;\n" +
                            "\t\t\t}\n" +
                            "\n" +
                            "\t\t\t.mobile_hide {\n" +
                            "\t\t\t\tmin-height: 0px;\n" +
                            "\t\t\t\tmax-height: 0px;\n" +
                            "\t\t\t\tmax-width: 0px;\n" +
                            "\t\t\t\tdisplay: none;\n" +
                            "\t\t\t\toverflow: hidden;\n" +
                            "\t\t\t\tfont-size: 0px;\n" +
                            "\t\t\t}\n" +
                            "\n" +
                            "\t\t\t.desktop_hide {\n" +
                            "\t\t\t\tdisplay: block !important;\n" +
                            "\t\t\t\tmax-height: none !important;\n" +
                            "\t\t\t}\n" +
                            "\t\t}\n" +
                            "\t</style>\n" +
                            "</head>\n" +
                            "\n" +
                            "<body class=\"clean-body\" style=\"margin: 0; padding: 0; -webkit-text-size-adjust: 100%; background-color: #e2eace;\">\n" +
                            "\t<!--[if IE]><div class=\"ie-browser\"><![endif]-->\n" +
                            "\t<table class=\"nl-container\" style=\"table-layout: fixed; vertical-align: top; min-width: 320px; Margin: 0 auto; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #e2eace; width: 100%;\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" width=\"100%\" bgcolor=\"#e2eace\" valign=\"top\">\n" +
                            "\t\t<tbody>\n" +
                            "\t\t\t<tr style=\"vertical-align: top;\" valign=\"top\">\n" +
                            "\t\t\t\t<td style=\"word-break: break-word; vertical-align: top;\" valign=\"top\">\n" +
                            "\t\t\t\t\t<!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td align=\"center\" style=\"background-color:#e2eace\"><![endif]-->\n" +
                            "\t\t\t\t\t<div style=\"background-color:transparent;\">\n" +
                            "\t\t\t\t\t\t<div class=\"block-grid \" style=\"Margin: 0 auto; min-width: 320px; max-width: 600px; overflow-wrap: break-word; word-wrap: break-word; word-break: break-word; background-color: transparent;\">\n" +
                            "\t\t\t\t\t\t\t<div style=\"border-collapse: collapse;display: table;width: 100%;background-color:transparent;\">\n" +
                            "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"background-color:transparent;\"><tr><td align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px\"><tr class=\"layout-full-width\" style=\"background-color:transparent\"><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]><td align=\"center\" width=\"600\" style=\"background-color:transparent;width:600px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top:5px; padding-bottom:0px;\"><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t<div class=\"col num12\" style=\"min-width: 320px; max-width: 600px; display: table-cell; vertical-align: top; width: 600px;\">\n" +
                            "\t\t\t\t\t\t\t\t\t<div style=\"width:100% !important;\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t<!--[if (!mso)&(!IE)]><!-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t<div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:5px; padding-bottom:0px; padding-right: 0px; padding-left: 0px;\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<!--<![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<div class=\"img-container center autowidth\" align=\"center\" style=\"padding-right: 0px;padding-left: 0px;\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr style=\"line-height:0px\"><td style=\"padding-right: 0px;padding-left: 0px;\" align=\"center\"><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"font-size:1px;line-height:25px\">&nbsp;</div><img class=\"center autowidth\" align=\"center\" border=\"0\" src=\"https://d1oco4z2z1fhwp.cloudfront.net/templates/default/20/rounder-up.png\" alt=\"Image\" title=\"Image\" style=\"text-decoration: none; -ms-interpolation-mode: bicubic; border: 0; height: auto; width: 100%; max-width: 600px; display: block;\" width=\"600\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]></td></tr></table><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<!--[if (!mso)&(!IE)]><!-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t\t\t<!--<![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]></td></tr></table></td></tr></table><![endif]-->\n" +
                            "\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t<div style=\"background-color:transparent;\">\n" +
                            "\t\t\t\t\t\t<div class=\"block-grid \" style=\"Margin: 0 auto; min-width: 320px; max-width: 600px; overflow-wrap: break-word; word-wrap: break-word; word-break: break-word; background-color: #FFFFFF;\">\n" +
                            "\t\t\t\t\t\t\t<div style=\"border-collapse: collapse;display: table;width: 100%;background-color:#FFFFFF;\">\n" +
                            "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"background-color:transparent;\"><tr><td align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px\"><tr class=\"layout-full-width\" style=\"background-color:#FFFFFF\"><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]><td align=\"center\" width=\"600\" style=\"background-color:#FFFFFF;width:600px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top:5px; padding-bottom:5px;\"><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t<div class=\"col num12\" style=\"min-width: 320px; max-width: 600px; display: table-cell; vertical-align: top; width: 600px;\">\n" +
                            "\t\t\t\t\t\t\t\t\t<div style=\"width:100% !important;\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t<!--[if (!mso)&(!IE)]><!-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t<div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:5px; padding-bottom:5px; padding-right: 0px; padding-left: 0px;\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<!--<![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<div class=\"img-container center\" align=\"center\" style=\"padding-right: 0px;padding-left: 0px;\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr style=\"line-height:0px\"><td style=\"padding-right: 0px;padding-left: 0px;\" align=\"center\"><![endif]--><img class=\"center\" align=\"center\" border=\"0\" src=\"https://cdn.itviec.com/employers/vis-soft/logo/social/DXErnqbxaE5NmyzrCp8EBBYG/vis-soft-logo.png\" alt=\"Image\" title=\"Image\" style=\"text-decoration: none; -ms-interpolation-mode: bicubic; border: 0; height: auto; width: 100%; max-width: 150px; display: block;\" width=\"150\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]></td></tr></table><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 10px; padding-left: 10px; padding-top: 10px; padding-bottom: 10px; font-family: Tahoma, sans-serif\"><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<div style=\"color:#555555;font-family:Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif;line-height:1.5;padding-top:10px;padding-right:10px;padding-bottom:10px;padding-left:10px;\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"font-size: 12px; line-height: 1.5; color: #555555; font-family: Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif; mso-line-height-alt: 18px;\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t<p style=\"font-size: 14px; line-height: 1.5; text-align: center; word-break: break-word; mso-line-height-alt: 21px; margin: 0;\">Công ty Cổ Phần Công Nghệ Và Truyền Thông VIS</p>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]></td></tr></table><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<!--[if (!mso)&(!IE)]><!-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t\t\t<!--<![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]></td></tr></table></td></tr></table><![endif]-->\n" +
                            "\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t<div style=\"background-color:transparent;\">\n" +
                            "\t\t\t\t\t\t<div class=\"block-grid \" style=\"Margin: 0 auto; min-width: 320px; max-width: 600px; overflow-wrap: break-word; word-wrap: break-word; word-break: break-word; background-color: #FFFFFF;\">\n" +
                            "\t\t\t\t\t\t\t<div style=\"border-collapse: collapse;display: table;width: 100%;background-color:#FFFFFF;\">\n" +
                            "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"background-color:transparent;\"><tr><td align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px\"><tr class=\"layout-full-width\" style=\"background-color:#FFFFFF\"><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]><td align=\"center\" width=\"600\" style=\"background-color:#FFFFFF;width:600px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top:0px; padding-bottom:5px;\"><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t<div class=\"col num12\" style=\"min-width: 320px; max-width: 600px; display: table-cell; vertical-align: top; width: 600px;\">\n" +
                            "\t\t\t\t\t\t\t\t\t<div style=\"width:100% !important;\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t<!--[if (!mso)&(!IE)]><!-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t<div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:0px; padding-bottom:5px; padding-right: 0px; padding-left: 0px;\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<!--<![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 10px; padding-left: 10px; padding-top: 10px; padding-bottom: 10px; font-family: Tahoma, sans-serif\"><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<div style=\"color:#0D0D0D;font-family:Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif;line-height:1.2;padding-top:10px;padding-right:10px;padding-bottom:10px;padding-left:10px;\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"font-size: 12px; line-height: 1.2; color: #0D0D0D; font-family: Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif; mso-line-height-alt: 14px;\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t<p style=\"font-size: 28px; line-height: 1.2; text-align: center; word-break: break-word; mso-line-height-alt: 34px; margin: 0;\"><span style=\"font-size: 28px;\"><strong>Thông báo nghỉ phép</strong></span></p>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]></td></tr></table><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<div class=\"img-container center\" align=\"center\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr style=\"line-height:0px\"><td style=\"\" align=\"center\"><![endif]--><img class=\"center\" align=\"center\" border=\"0\" src=\"https://d1oco4z2z1fhwp.cloudfront.net/templates/default/20/divider.png\" alt=\"Image\" title=\"Image\" style=\"text-decoration: none; -ms-interpolation-mode: bicubic; border: 0; height: auto; width: 100%; max-width: 318px; display: block;\" width=\"318\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]></td></tr></table><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 10px; padding-left: 10px; padding-top: 10px; padding-bottom: 10px; font-family: Tahoma, sans-serif\"><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<div style=\"color:#555555;font-family:Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif;line-height:1.5;padding-top:10px;padding-right:10px;padding-bottom:10px;padding-left:10px;\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"font-size: 12px; line-height: 1.5; color: #555555; font-family: Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif; mso-line-height-alt: 18px;\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t<p style=\"font-size: 14px; line-height: 1.5; text-align: center; word-break: break-word; mso-line-height-alt: 21px; margin: 0;\"><span style=\"color: #a8bf6f; font-size: 14px;\"><strong>Đơn xin nghỉ phép của "+ sender + " đã được "+approver+" duyệt</strong></span></p>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]></td></tr></table><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 10px; padding-left: 10px; padding-top: 20px; padding-bottom: 10px; font-family: Tahoma, sans-serif\"><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<div style=\"color:#0D0D0D;font-family:Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif;line-height:1.5;padding-top:20px;padding-right:10px;padding-bottom:10px;padding-left:10px;\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"line-height: 1.5; font-size: 12px; color: #0D0D0D; font-family: Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif; mso-line-height-alt: 18px;\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t<p style=\"line-height: 1.5; word-break: break-word; font-size: 14px; mso-line-height-alt: 21px; margin: 0;\"><span style=\"font-size: 14px;\"><strong>Thông tin chi tiết:</strong></span></p>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t<p style=\"line-height: 1.5; word-break: break-word; font-size: 14px; mso-line-height-alt: 21px; margin: 0;\"><span style=\"font-size: 14px;\">Người gửi: <strong>"+sender+"</strong></span></p>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t<p style=\"line-height: 1.5; word-break: break-word; font-size: 14px; mso-line-height-alt: 21px; margin: 0;\"><span style=\"font-size: 14px;\">Người duyệt: <strong>"+approver+"</strong></span></p>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t<p style=\"line-height: 1.5; word-break: break-word; font-size: 14px; mso-line-height-alt: 21px; margin: 0;\"><span style=\"font-size: 14px;\">Quản lí trên một cấp: <strong>"+managerLv2+"</strong></span></p>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t<p style=\"line-height: 1.5; word-break: break-word; font-size: 14px; mso-line-height-alt: 21px; margin: 0;\"><span style=\"font-size: 14px;\">Lý do:&nbsp;<strong>"+reason+"</strong></span></p>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t<p style=\"line-height: 1.5; word-break: break-word; font-size: 14px; mso-line-height-alt: 21px; margin: 0;\"><span style=\"font-size: 14px;\">Miêu tả<strong>: "+description+"</strong></span></p>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t<p style=\"line-height: 1.5; word-break: break-word; font-size: 14px; mso-line-height-alt: 21px; margin: 0;\"><span style=\"font-size: 14px;\">Ngày duyệt:<strong> "+approverDate+"</strong></span></p>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t<p style=\"line-height: 1.5; word-break: break-word; font-size: 14px; mso-line-height-alt: 21px; margin: 0;\"><span style=\"font-size: 14px;\">Ngày bắt đầu nghỉ:<strong> "+dateBegin+"</strong></span></p>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t<p style=\"line-height: 1.5; word-break: break-word; font-size: 14px; mso-line-height-alt: 21px; margin: 0;\"><span style=\"font-size: 14px;\">Ngày kết thúc nghỉ:<strong> "+dateEnd+"</strong></span></p>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t<p style=\"line-height: 1.5; word-break: break-word; font-size: 14px; mso-line-height-alt: 21px; margin: 0;\"><span "+cssStatus+" >Trạng thái:<strong> "+contentStatus+"</strong></span></p>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t<p style=\"line-height: 1.5; word-break: break-word; font-size: 14px; mso-line-height-alt: 21px; margin: 0;\"><span style=\"font-size: 14px;\" >Ghi chú:<strong> "+reasonReject+"</strong></span></p>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t<p style=\"line-height: 1.5; word-break: break-word; mso-line-height-alt: NaNpx; margin: 0;\">&nbsp;</p>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t<p style=\"line-height: 1.5; word-break: break-word; font-size: 14px; mso-line-height-alt: 21px; margin: 0;\"><span style=\"font-size: 14px;\"><strong>Xin cảm ơn!</strong></span></p>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]></td></tr></table><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<table class=\"divider\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;\" role=\"presentation\" valign=\"top\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t<tbody>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t<tr style=\"vertical-align: top;\" valign=\"top\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"divider_inner\" style=\"word-break: break-word; vertical-align: top; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%; padding-top: 30px; padding-right: 10px; padding-bottom: 10px; padding-left: 10px;\" valign=\"top\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<table class=\"divider_content\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-top: 0px solid transparent; width: 100%;\" align=\"center\" role=\"presentation\" valign=\"top\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tbody>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr style=\"vertical-align: top;\" valign=\"top\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td style=\"word-break: break-word; vertical-align: top; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;\" valign=\"top\"><span></span></td>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tbody>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</table>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t</tbody>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t</table>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<!--[if (!mso)&(!IE)]><!-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t\t\t<!--<![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]></td></tr></table></td></tr></table><![endif]-->\n" +
                            "\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t<div style=\"background-color:transparent;\">\n" +
                            "\t\t\t\t\t\t<div class=\"block-grid three-up\" style=\"Margin: 0 auto; min-width: 320px; max-width: 600px; overflow-wrap: break-word; word-wrap: break-word; word-break: break-word; background-color: #525252;\">\n" +
                            "\t\t\t\t\t\t\t<div style=\"border-collapse: collapse;display: table;width: 100%;background-color:#525252;\">\n" +
                            "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"background-color:transparent;\"><tr><td align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px\"><tr class=\"layout-full-width\" style=\"background-color:#525252\"><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]><td align=\"center\" width=\"200\" style=\"background-color:#525252;width:200px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top:0px; padding-bottom:0px;\"><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t<div class=\"col num4\" style=\"max-width: 320px; min-width: 200px; display: table-cell; vertical-align: top; width: 200px;\">\n" +
                            "\t\t\t\t\t\t\t\t\t<div style=\"width:100% !important;\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t<!--[if (!mso)&(!IE)]><!-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t<div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:0px; padding-bottom:0px; padding-right: 0px; padding-left: 0px;\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<!--<![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<table class=\"social_icons\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" role=\"presentation\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" valign=\"top\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t<tbody>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t<tr style=\"vertical-align: top;\" valign=\"top\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td style=\"word-break: break-word; vertical-align: top; padding-top: 15px; padding-right: 0px; padding-bottom: 0px; padding-left: 0px;\" valign=\"top\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<table class=\"social_table\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-tspace: 0; mso-table-rspace: 0; mso-table-bspace: 0; mso-table-lspace: 0;\" valign=\"top\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tbody>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr style=\"vertical-align: top; display: inline-block; text-align: center;\" align=\"center\" valign=\"top\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td style=\"word-break: break-word; vertical-align: top; padding-bottom: 5px; padding-right: 3px; padding-left: 3px;\" valign=\"top\"><a href=\"https://www.facebook.com/\" target=\"_blank\"><img width=\"32\" height=\"32\" src=\"https://d2fi4ri5dhpqd1.cloudfront.net/public/resources/social-networks-icon-sets/t-only-logo-default-gray/facebook@2x.png\" alt=\"Facebook\" title=\"Facebook\" style=\"text-decoration: none; -ms-interpolation-mode: bicubic; height: auto; border: none; display: block;\"></a></td>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td style=\"word-break: break-word; vertical-align: top; padding-bottom: 5px; padding-right: 3px; padding-left: 3px;\" valign=\"top\"><a href=\"https://twitter.com/\" target=\"_blank\"><img width=\"32\" height=\"32\" src=\"https://d2fi4ri5dhpqd1.cloudfront.net/public/resources/social-networks-icon-sets/t-only-logo-default-gray/twitter@2x.png\" alt=\"Twitter\" title=\"Twitter\" style=\"text-decoration: none; -ms-interpolation-mode: bicubic; height: auto; border: none; display: block;\"></a></td>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td style=\"word-break: break-word; vertical-align: top; padding-bottom: 5px; padding-right: 3px; padding-left: 3px;\" valign=\"top\"><a href=\"https://plus.google.com/\" target=\"_blank\"><img width=\"32\" height=\"32\" src=\"https://d2fi4ri5dhpqd1.cloudfront.net/public/resources/social-networks-icon-sets/t-only-logo-default-gray/googleplus@2x.png\" alt=\"Google+\" title=\"Google+\" style=\"text-decoration: none; -ms-interpolation-mode: bicubic; height: auto; border: none; display: block;\"></a></td>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tbody>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</table>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t</tbody>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t</table>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<!--[if (!mso)&(!IE)]><!-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t\t\t<!--<![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]></td><td align=\"center\" width=\"200\" style=\"background-color:#525252;width:200px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top:5px; padding-bottom:5px;\"><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t<div class=\"col num4\" style=\"max-width: 320px; min-width: 200px; display: table-cell; vertical-align: top; width: 200px;\">\n" +
                            "\t\t\t\t\t\t\t\t\t<div style=\"width:100% !important;\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t<!--[if (!mso)&(!IE)]><!-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t<div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:5px; padding-bottom:5px; padding-right: 0px; padding-left: 0px;\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<!--<![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top: 20px; padding-bottom: 0px; font-family: Tahoma, sans-serif\"><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<div style=\"color:#a8bf6f;font-family:Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif;line-height:1.2;padding-top:20px;padding-right:0px;padding-bottom:0px;padding-left:0px;\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"font-size: 12px; line-height: 1.2; color: #a8bf6f; font-family: Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif; mso-line-height-alt: 14px;\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t<p style=\"font-size: 12px; line-height: 1.2; text-align: center; word-break: break-word; mso-line-height-alt: 14px; margin: 0;\"><span style=\"color: #ffffff; font-size: 12px;\"><span style=\"font-size: 12px; color: #a8bf6f;\">Tel.:</span> +(024) - 666 20346</span></p>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]></td></tr></table><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<!--[if (!mso)&(!IE)]><!-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t\t\t<!--<![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]></td><td align=\"center\" width=\"200\" style=\"background-color:#525252;width:200px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top:5px; padding-bottom:5px;\"><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t<div class=\"col num4\" style=\"max-width: 320px; min-width: 200px; display: table-cell; vertical-align: top; width: 200px;\">\n" +
                            "\t\t\t\t\t\t\t\t\t<div style=\"width:100% !important;\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t<!--[if (!mso)&(!IE)]><!-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t<div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:5px; padding-bottom:5px; padding-right: 0px; padding-left: 0px;\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<!--<![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top: 20px; padding-bottom: 0px; font-family: Tahoma, sans-serif\"><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<div style=\"color:#a8bf6f;font-family:Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif;line-height:1.2;padding-top:20px;padding-right:0px;padding-bottom:0px;padding-left:0px;\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"font-size: 12px; line-height: 1.2; color: #a8bf6f; font-family: Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif; mso-line-height-alt: 14px;\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t<p style=\"font-size: 12px; line-height: 1.2; text-align: center; word-break: break-word; mso-line-height-alt: 14px; margin: 0;\">Email&nbsp;<span style=\"color: #ffffff;\">Contact@vissoft.vn</span></p>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]></td></tr></table><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<!--[if (!mso)&(!IE)]><!-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t\t\t<!--<![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]></td></tr></table></td></tr></table><![endif]-->\n" +
                            "\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t<div style=\"background-color:transparent;\">\n" +
                            "\t\t\t\t\t\t<div class=\"block-grid \" style=\"Margin: 0 auto; min-width: 320px; max-width: 600px; overflow-wrap: break-word; word-wrap: break-word; word-break: break-word; background-color: transparent;\">\n" +
                            "\t\t\t\t\t\t\t<div style=\"border-collapse: collapse;display: table;width: 100%;background-color:transparent;\">\n" +
                            "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"background-color:transparent;\"><tr><td align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px\"><tr class=\"layout-full-width\" style=\"background-color:transparent\"><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]><td align=\"center\" width=\"600\" style=\"background-color:transparent;width:600px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top:0px; padding-bottom:5px;\"><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t<div class=\"col num12\" style=\"min-width: 320px; max-width: 600px; display: table-cell; vertical-align: top; width: 600px;\">\n" +
                            "\t\t\t\t\t\t\t\t\t<div style=\"width:100% !important;\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t<!--[if (!mso)&(!IE)]><!-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t<div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:0px; padding-bottom:5px; padding-right: 0px; padding-left: 0px;\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<!--<![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<div class=\"img-container center autowidth\" align=\"center\" style=\"padding-right: 0px;padding-left: 0px;\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr style=\"line-height:0px\"><td style=\"padding-right: 0px;padding-left: 0px;\" align=\"center\"><![endif]--><img class=\"center autowidth\" align=\"center\" border=\"0\" src=\"https://d1oco4z2z1fhwp.cloudfront.net/templates/default/20/rounder-dwn.png\" alt=\"Image\" title=\"Image\" style=\"text-decoration: none; -ms-interpolation-mode: bicubic; border: 0; height: auto; width: 100%; max-width: 600px; display: block;\" width=\"600\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]></td></tr></table><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<table class=\"divider\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;\" role=\"presentation\" valign=\"top\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t<tbody>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t<tr style=\"vertical-align: top;\" valign=\"top\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"divider_inner\" style=\"word-break: break-word; vertical-align: top; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%; padding-top: 30px; padding-right: 30px; padding-bottom: 30px; padding-left: 30px;\" valign=\"top\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<table class=\"divider_content\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-top: 0px solid transparent; width: 100%;\" align=\"center\" role=\"presentation\" valign=\"top\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tbody>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr style=\"vertical-align: top;\" valign=\"top\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td style=\"word-break: break-word; vertical-align: top; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;\" valign=\"top\"><span></span></td>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tbody>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</table>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t</tbody>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t</table>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<!--[if (!mso)&(!IE)]><!-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t\t\t<!--<![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]></td></tr></table></td></tr></table><![endif]-->\n" +
                            "\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n" +
                            "\t\t\t\t</td>\n" +
                            "\t\t\t</tr>\n" +
                            "\t\t</tbody>\n" +
                            "\t</table>\n" +
                            "\t<!--[if (IE)]></div><![endif]-->\n" +
                            "</body>\n" +
                            "\n" +
                            "</html>";
            return emailContentReject;
        }
    }

    @Override
    public String emailWarring(
            String username,
            String fullName,
            String dateBegin,
            String dateEnd,
            String reasonName,
            String description
    ) {

        String emailContent =
                "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional //EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
                        "<html xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:v=\"urn:schemas-microsoft-com:vml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\">\n" +
                        "\n" +
                        "<head>\n" +
                        "\t<!--[if gte mso 9]><xml><o:OfficeDocumentSettings><o:AllowPNG/><o:PixelsPerInch>96</o:PixelsPerInch></o:OfficeDocumentSettings></xml><![endif]-->\n" +
                        "\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\n" +
                        "\t<meta name=\"viewport\" content=\"width=device-width\">\n" +
                        "\t<!--[if !mso]><!-->\n" +
                        "\t<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
                        "\t<!--<![endif]-->\n" +
                        "\t<title></title>\n" +
                        "\t<!--[if !mso]><!-->\n" +
                        "\t<link href=\"https://fonts.googleapis.com/css?family=Montserrat\" rel=\"stylesheet\" type=\"text/css\">\n" +
                        "\t<!--<![endif]-->\n" +
                        "\t<style type=\"text/css\">\n" +
                        "\t\tbody {\n" +
                        "\t\t\tmargin: 0;\n" +
                        "\t\t\tpadding: 0;\n" +
                        "\t\t}\n" +
                        "\n" +
                        "\t\ttable,\n" +
                        "\t\ttd,\n" +
                        "\t\ttr {\n" +
                        "\t\t\tvertical-align: top;\n" +
                        "\t\t\tborder-collapse: collapse;\n" +
                        "\t\t}\n" +
                        "\n" +
                        "\t\t* {\n" +
                        "\t\t\tline-height: inherit;\n" +
                        "\t\t}\n" +
                        "\n" +
                        "\t\ta[x-apple-data-detectors=true] {\n" +
                        "\t\t\tcolor: inherit !important;\n" +
                        "\t\t\ttext-decoration: none !important;\n" +
                        "\t\t}\n" +
                        "\t</style>\n" +
                        "\t<style type=\"text/css\" id=\"media-query\">\n" +
                        "\t\t@media (max-width: 620px) {\n" +
                        "\n" +
                        "\t\t\t.block-grid,\n" +
                        "\t\t\t.col {\n" +
                        "\t\t\t\tmin-width: 320px !important;\n" +
                        "\t\t\t\tmax-width: 100% !important;\n" +
                        "\t\t\t\tdisplay: block !important;\n" +
                        "\t\t\t}\n" +
                        "\n" +
                        "\t\t\t.block-grid {\n" +
                        "\t\t\t\twidth: 100% !important;\n" +
                        "\t\t\t}\n" +
                        "\n" +
                        "\t\t\t.col {\n" +
                        "\t\t\t\twidth: 100% !important;\n" +
                        "\t\t\t}\n" +
                        "\n" +
                        "\t\t\t.col>div {\n" +
                        "\t\t\t\tmargin: 0 auto;\n" +
                        "\t\t\t}\n" +
                        "\n" +
                        "\t\t\timg.fullwidth,\n" +
                        "\t\t\timg.fullwidthOnMobile {\n" +
                        "\t\t\t\tmax-width: 100% !important;\n" +
                        "\t\t\t}\n" +
                        "\n" +
                        "\t\t\t.no-stack .col {\n" +
                        "\t\t\t\tmin-width: 0 !important;\n" +
                        "\t\t\t\tdisplay: table-cell !important;\n" +
                        "\t\t\t}\n" +
                        "\n" +
                        "\t\t\t.no-stack.two-up .col {\n" +
                        "\t\t\t\twidth: 50% !important;\n" +
                        "\t\t\t}\n" +
                        "\n" +
                        "\t\t\t.no-stack .col.num4 {\n" +
                        "\t\t\t\twidth: 33% !important;\n" +
                        "\t\t\t}\n" +
                        "\n" +
                        "\t\t\t.no-stack .col.num8 {\n" +
                        "\t\t\t\twidth: 66% !important;\n" +
                        "\t\t\t}\n" +
                        "\n" +
                        "\t\t\t.no-stack .col.num4 {\n" +
                        "\t\t\t\twidth: 33% !important;\n" +
                        "\t\t\t}\n" +
                        "\n" +
                        "\t\t\t.no-stack .col.num3 {\n" +
                        "\t\t\t\twidth: 25% !important;\n" +
                        "\t\t\t}\n" +
                        "\n" +
                        "\t\t\t.no-stack .col.num6 {\n" +
                        "\t\t\t\twidth: 50% !important;\n" +
                        "\t\t\t}\n" +
                        "\n" +
                        "\t\t\t.no-stack .col.num9 {\n" +
                        "\t\t\t\twidth: 75% !important;\n" +
                        "\t\t\t}\n" +
                        "\n" +
                        "\t\t\t.video-block {\n" +
                        "\t\t\t\tmax-width: none !important;\n" +
                        "\t\t\t}\n" +
                        "\n" +
                        "\t\t\t.mobile_hide {\n" +
                        "\t\t\t\tmin-height: 0px;\n" +
                        "\t\t\t\tmax-height: 0px;\n" +
                        "\t\t\t\tmax-width: 0px;\n" +
                        "\t\t\t\tdisplay: none;\n" +
                        "\t\t\t\toverflow: hidden;\n" +
                        "\t\t\t\tfont-size: 0px;\n" +
                        "\t\t\t}\n" +
                        "\n" +
                        "\t\t\t.desktop_hide {\n" +
                        "\t\t\t\tdisplay: block !important;\n" +
                        "\t\t\t\tmax-height: none !important;\n" +
                        "\t\t\t}\n" +
                        "\t\t}\n" +
                        "\t</style>\n" +
                        "</head>\n" +
                        "\n" +
                        "<body class=\"clean-body\" style=\"margin: 0; padding: 0; -webkit-text-size-adjust: 100%; background-color: #e2eace;\">\n" +
                        "\t<!--[if IE]><div class=\"ie-browser\"><![endif]-->\n" +
                        "\t<table class=\"nl-container\" style=\"table-layout: fixed; vertical-align: top; min-width: 320px; Margin: 0 auto; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #e2eace; width: 100%;\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" width=\"100%\" bgcolor=\"#e2eace\" valign=\"top\">\n" +
                        "\t\t<tbody>\n" +
                        "\t\t\t<tr style=\"vertical-align: top;\" valign=\"top\">\n" +
                        "\t\t\t\t<td style=\"word-break: break-word; vertical-align: top;\" valign=\"top\">\n" +
                        "\t\t\t\t\t<!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td align=\"center\" style=\"background-color:#e2eace\"><![endif]-->\n" +
                        "\t\t\t\t\t<div style=\"background-color:transparent;\">\n" +
                        "\t\t\t\t\t\t<div class=\"block-grid \" style=\"Margin: 0 auto; min-width: 320px; max-width: 600px; overflow-wrap: break-word; word-wrap: break-word; word-break: break-word; background-color: transparent;\">\n" +
                        "\t\t\t\t\t\t\t<div style=\"border-collapse: collapse;display: table;width: 100%;background-color:transparent;\">\n" +
                        "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"background-color:transparent;\"><tr><td align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px\"><tr class=\"layout-full-width\" style=\"background-color:transparent\"><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]><td align=\"center\" width=\"600\" style=\"background-color:transparent;width:600px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top:5px; padding-bottom:0px;\"><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t<div class=\"col num12\" style=\"min-width: 320px; max-width: 600px; display: table-cell; vertical-align: top; width: 600px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t<div style=\"width:100% !important;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t<!--[if (!mso)&(!IE)]><!-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t<div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:5px; padding-bottom:0px; padding-right: 0px; padding-left: 0px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<!--<![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<div class=\"img-container center autowidth\" align=\"center\" style=\"padding-right: 0px;padding-left: 0px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr style=\"line-height:0px\"><td style=\"padding-right: 0px;padding-left: 0px;\" align=\"center\"><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"font-size:1px;line-height:25px\">&nbsp;</div><img class=\"center autowidth\" align=\"center\" border=\"0\" src=\"https://d1oco4z2z1fhwp.cloudfront.net/templates/default/20/rounder-up.png\" alt=\"Image\" title=\"Image\" style=\"text-decoration: none; -ms-interpolation-mode: bicubic; border: 0; height: auto; width: 100%; max-width: 600px; display: block;\" width=\"600\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]></td></tr></table><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<!--[if (!mso)&(!IE)]><!-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t\t\t<!--<![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]></td></tr></table></td></tr></table><![endif]-->\n" +
                        "\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t<div style=\"background-color:transparent;\">\n" +
                        "\t\t\t\t\t\t<div class=\"block-grid \" style=\"Margin: 0 auto; min-width: 320px; max-width: 600px; overflow-wrap: break-word; word-wrap: break-word; word-break: break-word; background-color: #FFFFFF;\">\n" +
                        "\t\t\t\t\t\t\t<div style=\"border-collapse: collapse;display: table;width: 100%;background-color:#FFFFFF;\">\n" +
                        "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"background-color:transparent;\"><tr><td align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px\"><tr class=\"layout-full-width\" style=\"background-color:#FFFFFF\"><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]><td align=\"center\" width=\"600\" style=\"background-color:#FFFFFF;width:600px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top:5px; padding-bottom:5px;\"><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t<div class=\"col num12\" style=\"min-width: 320px; max-width: 600px; display: table-cell; vertical-align: top; width: 600px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t<div style=\"width:100% !important;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t<!--[if (!mso)&(!IE)]><!-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t<div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:5px; padding-bottom:5px; padding-right: 0px; padding-left: 0px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<!--<![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<div class=\"img-container center\" align=\"center\" style=\"padding-right: 0px;padding-left: 0px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr style=\"line-height:0px\"><td style=\"padding-right: 0px;padding-left: 0px;\" align=\"center\"><![endif]--><img class=\"center\" align=\"center\" border=\"0\" src=\"https://media.licdn.com/dms/image/C561BAQFvBoDlloIR4w/company-background_10000/0?e=2159024400&amp;v=beta&amp;t=vmTY91FoP8rQRgvgePKIao5DgLbbV3pGjlLfFwHIwwM\" alt=\"Image\" title=\"Image\" style=\"text-decoration: none; -ms-interpolation-mode: bicubic; border: 0; height: auto; width: 100%; max-width: 360px; display: block;\" width=\"360\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]></td></tr></table><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 10px; padding-left: 10px; padding-top: 10px; padding-bottom: 10px; font-family: Tahoma, sans-serif\"><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<div style=\"color:#555555;font-family:Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif;line-height:1.5;padding-top:10px;padding-right:10px;padding-bottom:10px;padding-left:10px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"font-size: 12px; line-height: 1.5; color: #555555; font-family: Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif; mso-line-height-alt: 18px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t<p style=\"font-size: 14px; line-height: 1.5; text-align: center; word-break: break-word; mso-line-height-alt: 21px; margin: 0;\">Công Ty Cổ Phần Công Nghệ Và Truyền Thông VIS</p>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]></td></tr></table><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<!--[if (!mso)&(!IE)]><!-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t\t\t<!--<![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]></td></tr></table></td></tr></table><![endif]-->\n" +
                        "\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t<div style=\"background-color:transparent;\">\n" +
                        "\t\t\t\t\t\t<div class=\"block-grid \" style=\"Margin: 0 auto; min-width: 320px; max-width: 600px; overflow-wrap: break-word; word-wrap: break-word; word-break: break-word; background-color: #FFFFFF;\">\n" +
                        "\t\t\t\t\t\t\t<div style=\"border-collapse: collapse;display: table;width: 100%;background-color:#FFFFFF;\">\n" +
                        "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"background-color:transparent;\"><tr><td align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px\"><tr class=\"layout-full-width\" style=\"background-color:#FFFFFF\"><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]><td align=\"center\" width=\"600\" style=\"background-color:#FFFFFF;width:600px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top:0px; padding-bottom:5px;\"><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t<div class=\"col num12\" style=\"min-width: 320px; max-width: 600px; display: table-cell; vertical-align: top; width: 600px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t<div style=\"width:100% !important;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t<!--[if (!mso)&(!IE)]><!-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t<div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:0px; padding-bottom:5px; padding-right: 0px; padding-left: 0px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<!--<![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 10px; padding-left: 10px; padding-top: 10px; padding-bottom: 10px; font-family: Tahoma, sans-serif\"><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<div style=\"color:#0D0D0D;font-family:Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif;line-height:1.2;padding-top:10px;padding-right:10px;padding-bottom:10px;padding-left:10px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"font-size: 12px; line-height: 1.2; color: #0D0D0D; font-family: Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif; mso-line-height-alt: 14px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t<p style=\"font-size: 28px; line-height: 1.2; text-align: center; word-break: break-word; mso-line-height-alt: 34px; margin: 0;\"><span style=\"font-size: 28px;\"><strong>Thông báo nghỉ phép</strong></span></p>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]></td></tr></table><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<div class=\"img-container center\" align=\"center\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr style=\"line-height:0px\"><td style=\"\" align=\"center\"><![endif]--><img class=\"center\" align=\"center\" border=\"0\" src=\"https://d1oco4z2z1fhwp.cloudfront.net/templates/default/20/divider.png\" alt=\"Image\" title=\"Image\" style=\"text-decoration: none; -ms-interpolation-mode: bicubic; border: 0; height: auto; width: 100%; max-width: 318px; display: block;\" width=\"318\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]></td></tr></table><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 10px; padding-left: 10px; padding-top: 10px; padding-bottom: 10px; font-family: Tahoma, sans-serif\"><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<div style=\"color:#555555;font-family:Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif;line-height:1.5;padding-top:10px;padding-right:10px;padding-bottom:10px;padding-left:10px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"font-size: 12px; line-height: 1.5; color: #555555; font-family: Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif; mso-line-height-alt: 18px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t<p style=\"font-size: 14px; line-height: 1.5; text-align: center; word-break: break-word; mso-line-height-alt: 21px; margin: 0;\"><span style=\"color: #a8bf6f; font-size: 14px;\"><strong>Chào anh/chị!</strong></span></p>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t<p style=\"font-size: 14px; line-height: 1.5; text-align: center; word-break: break-word; mso-line-height-alt: 21px; margin: 0;\"><span style=\"color: #a8bf6f; font-size: 14px;\"><strong>Có 1 đơn xin nghỉ cần được anh/chị duyệt trước 10h00 ngày hôm nay!</strong></span></p>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]></td></tr></table><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 10px; padding-left: 10px; padding-top: 20px; padding-bottom: 10px; font-family: Tahoma, sans-serif\"><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<div style=\"color:#0D0D0D;font-family:Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif;line-height:1.5;padding-top:20px;padding-right:10px;padding-bottom:10px;padding-left:10px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"line-height: 1.5; font-size: 12px; color: #0D0D0D; font-family: Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif; mso-line-height-alt: 18px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t<p style=\"line-height: 1.5; word-break: break-word; font-size: 14px; mso-line-height-alt: 21px; margin: 0;\"><span style=\"font-size: 14px;\">Thông tin chi tiết:</span></p>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t<p style=\"line-height: 1.5; word-break: break-word; font-size: 14px; mso-line-height-alt: 21px; margin: 0;\"><span style=\"font-size: 14px;\">Người gửi:<strong> "+ username +" (" +fullName+")" + "&nbsp;</strong></span></p>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t<p style=\"line-height: 1.5; word-break: break-word; font-size: 14px; mso-line-height-alt: 21px; margin: 0;\"><span style=\"font-size: 14px;\">"+reasonName+" với lý do: <strong>"+description+"</strong></span></p>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t<p style=\"line-height: 1.5; word-break: break-word; font-size: 14px; mso-line-height-alt: 21px; margin: 0;\"><span style=\"font-size: 14px;\"><strong>Cảm ơn !!</strong></span></p>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]></td></tr></table><![endif]-->\n" +

                        "\t\t\t\t\t\t\t\t\t\t\t<div class=\"button-container\" align=\"center\" style=\"padding-top:25px;padding-right:10px;padding-bottom:10px;padding-left:10px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"border-spacing: 0; border-collapse: collapse; mso-table-lspace:0pt; mso-table-rspace:0pt;\"><tr><td style=\"padding-top: 25px; padding-right: 10px; padding-bottom: 10px; padding-left: 10px\" align=\"center\"><v:roundrect xmlns:v=\"urn:schemas-microsoft-com:vml\" xmlns:w=\"urn:schemas-microsoft-com:office:word\" href=\"http://14.225.5.246:8864/#/timeoff-management\" style=\"height:46.5pt; width:100.5pt; v-text-anchor:middle;\" arcsize=\"7%\" stroke=\"false\" fillcolor=\"#a8bf6f\"><w:anchorlock/><v:textbox inset=\"0,0,0,0\"><center style=\"color:#ffffff; font-family:Tahoma, sans-serif; font-size:16px\"><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t<a href=\"http://14.225.5.246:8864/#/timeoff-management\" target=\"_blank\" style=\"-webkit-text-size-adjust: none; text-decoration: none; display: inline-block; color: #ffffff; background-color: #a8bf6f; border-radius: 4px; -webkit-border-radius: 4px; -moz-border-radius: 4px; width: auto; width: auto; border-top: 1px solid #a8bf6f; border-right: 1px solid #a8bf6f; border-bottom: 1px solid #a8bf6f; border-left: 1px solid #a8bf6f; padding-top: 15px; padding-bottom: 15px; font-family: Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif; text-align: center; mso-border-alt: none; word-break: keep-all;\"><span style=\"padding-left:15px;padding-right:15px;font-size:16px;display:inline-block;\"><span style=\"font-size: 16px; line-height: 2; word-break: break-word; mso-line-height-alt: 32px;\">Duyệt đơn xin nghỉ</span></span></a>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]></center></v:textbox></v:roundrect></td></tr></table><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t</div>\n" +

                        "\t\t\t\t\t\t\t\t\t\t\t<table class=\"divider\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;\" role=\"presentation\" valign=\"top\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t<tbody>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t<tr style=\"vertical-align: top;\" valign=\"top\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"divider_inner\" style=\"word-break: break-word; vertical-align: top; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%; padding-top: 30px; padding-right: 10px; padding-bottom: 10px; padding-left: 10px;\" valign=\"top\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<table class=\"divider_content\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-top: 0px solid transparent; width: 100%;\" align=\"center\" role=\"presentation\" valign=\"top\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tbody>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr style=\"vertical-align: top;\" valign=\"top\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td style=\"word-break: break-word; vertical-align: top; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;\" valign=\"top\"><span></span></td>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tbody>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</table>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t</tbody>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t</table>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<!--[if (!mso)&(!IE)]><!-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t\t\t<!--<![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]></td></tr></table></td></tr></table><![endif]-->\n" +
                        "\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t<div style=\"background-color:transparent;\">\n" +
                        "\t\t\t\t\t\t<div class=\"block-grid three-up\" style=\"Margin: 0 auto; min-width: 320px; max-width: 600px; overflow-wrap: break-word; word-wrap: break-word; word-break: break-word; background-color: #525252;\">\n" +
                        "\t\t\t\t\t\t\t<div style=\"border-collapse: collapse;display: table;width: 100%;background-color:#525252;\">\n" +
                        "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"background-color:transparent;\"><tr><td align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px\"><tr class=\"layout-full-width\" style=\"background-color:#525252\"><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]><td align=\"center\" width=\"200\" style=\"background-color:#525252;width:200px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top:0px; padding-bottom:0px;\"><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t<div class=\"col num4\" style=\"max-width: 320px; min-width: 200px; display: table-cell; vertical-align: top; width: 200px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t<div style=\"width:100% !important;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t<!--[if (!mso)&(!IE)]><!-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t<div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:0px; padding-bottom:0px; padding-right: 0px; padding-left: 0px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<!--<![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<table class=\"social_icons\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" role=\"presentation\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" valign=\"top\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t<tbody>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t<tr style=\"vertical-align: top;\" valign=\"top\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td style=\"word-break: break-word; vertical-align: top; padding-top: 15px; padding-right: 0px; padding-bottom: 0px; padding-left: 0px;\" valign=\"top\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<table class=\"social_table\" align=\"center\" to=\"to\" activate=\"activate\" alignment=\"alignment\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: undefined; mso-table-tspace: 0; mso-table-rspace: 0; mso-table-bspace: 0; mso-table-lspace: 0;\" valign=\"top\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tbody>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr style=\"vertical-align: top; display: inline-block; text-align: center;\" align=\"center\" valign=\"top\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td style=\"word-break: break-word; vertical-align: top; padding-bottom: 5px; padding-right: 3px; padding-left: 3px;\" valign=\"top\"><a href=\"http://vissoft.vn\" target=\"_blank\"><img width=\"32\" height=\"32\" src=\"https://d2fi4ri5dhpqd1.cloudfront.net/public/resources/social-networks-icon-sets/t-only-logo-default-gray/facebook@2x.png\" alt=\"Facebook\" title=\"Facebook\" style=\"text-decoration: none; -ms-interpolation-mode: bicubic; height: auto; border: none; display: block;\"></a></td>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td style=\"word-break: break-word; vertical-align: top; padding-bottom: 5px; padding-right: 3px; padding-left: 3px;\" valign=\"top\"><a href=\"http://vissoft.vn\" target=\"_blank\"><img width=\"32\" height=\"32\" src=\"https://d2fi4ri5dhpqd1.cloudfront.net/public/resources/social-networks-icon-sets/t-only-logo-default-gray/twitter@2x.png\" alt=\"Twitter\" title=\"Twitter\" style=\"text-decoration: none; -ms-interpolation-mode: bicubic; height: auto; border: none; display: block;\"></a></td>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td style=\"word-break: break-word; vertical-align: top; padding-bottom: 5px; padding-right: 3px; padding-left: 3px;\" valign=\"top\"><a href=\"http://vissoft.vn\" target=\"_blank\"><img width=\"32\" height=\"32\" src=\"https://d2fi4ri5dhpqd1.cloudfront.net/public/resources/social-networks-icon-sets/t-only-logo-default-gray/googleplus@2x.png\" alt=\"Google+\" title=\"Google+\" style=\"text-decoration: none; -ms-interpolation-mode: bicubic; height: auto; border: none; display: block;\"></a></td>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tbody>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</table>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t</tbody>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t</table>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<!--[if (!mso)&(!IE)]><!-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t\t\t<!--<![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]></td><td align=\"center\" width=\"200\" style=\"background-color:#525252;width:200px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top:5px; padding-bottom:5px;\"><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t<div class=\"col num4\" style=\"max-width: 320px; min-width: 200px; display: table-cell; vertical-align: top; width: 200px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t<div style=\"width:100% !important;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t<!--[if (!mso)&(!IE)]><!-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t<div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:5px; padding-bottom:5px; padding-right: 0px; padding-left: 0px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<!--<![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top: 20px; padding-bottom: 0px; font-family: Tahoma, sans-serif\"><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<div style=\"color:#a8bf6f;font-family:Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif;line-height:1.2;padding-top:20px;padding-right:0px;padding-bottom:0px;padding-left:0px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"font-size: 12px; line-height: 1.2; color: #a8bf6f; font-family: Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif; mso-line-height-alt: 14px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t<p style=\"font-size: 12px; line-height: 1.2; text-align: center; word-break: break-word; mso-line-height-alt: 14px; margin: 0;\"><span style=\"color: #ffffff; font-size: 12px;\"><span style=\"font-size: 12px; color: #a8bf6f;\">Tel.:</span> +(024) - 666 20346</span></p>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]></td></tr></table><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<!--[if (!mso)&(!IE)]><!-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t\t\t<!--<![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]></td><td align=\"center\" width=\"200\" style=\"background-color:#525252;width:200px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top:5px; padding-bottom:5px;\"><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t<div class=\"col num4\" style=\"max-width: 320px; min-width: 200px; display: table-cell; vertical-align: top; width: 200px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t<div style=\"width:100% !important;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t<!--[if (!mso)&(!IE)]><!-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t<div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:5px; padding-bottom:5px; padding-right: 0px; padding-left: 0px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<!--<![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top: 20px; padding-bottom: 0px; font-family: Tahoma, sans-serif\"><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<div style=\"color:#a8bf6f;font-family:Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif;line-height:1.2;padding-top:20px;padding-right:0px;padding-bottom:0px;padding-left:0px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"font-size: 12px; line-height: 1.2; color: #a8bf6f; font-family: Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif; mso-line-height-alt: 14px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t<p style=\"font-size: 12px; line-height: 1.2; text-align: center; word-break: break-word; mso-line-height-alt: 14px; margin: 0;\">Email <span style=\"color: #ffffff; font-size: 12px;\">contact@vissoft.vn</span></p>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]></td></tr></table><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<!--[if (!mso)&(!IE)]><!-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t\t\t<!--<![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]></td></tr></table></td></tr></table><![endif]-->\n" +
                        "\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t<div style=\"background-color:transparent;\">\n" +
                        "\t\t\t\t\t\t<div class=\"block-grid \" style=\"Margin: 0 auto; min-width: 320px; max-width: 600px; overflow-wrap: break-word; word-wrap: break-word; word-break: break-word; background-color: transparent;\">\n" +
                        "\t\t\t\t\t\t\t<div style=\"border-collapse: collapse;display: table;width: 100%;background-color:transparent;\">\n" +
                        "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"background-color:transparent;\"><tr><td align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px\"><tr class=\"layout-full-width\" style=\"background-color:transparent\"><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]><td align=\"center\" width=\"600\" style=\"background-color:transparent;width:600px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top:0px; padding-bottom:5px;\"><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t<div class=\"col num12\" style=\"min-width: 320px; max-width: 600px; display: table-cell; vertical-align: top; width: 600px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t<div style=\"width:100% !important;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t<!--[if (!mso)&(!IE)]><!-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t<div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:0px; padding-bottom:5px; padding-right: 0px; padding-left: 0px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<!--<![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<div class=\"img-container center autowidth\" align=\"center\" style=\"padding-right: 0px;padding-left: 0px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr style=\"line-height:0px\"><td style=\"padding-right: 0px;padding-left: 0px;\" align=\"center\"><![endif]--><img class=\"center autowidth\" align=\"center\" border=\"0\" src=\"https://d1oco4z2z1fhwp.cloudfront.net/templates/default/20/rounder-dwn.png\" alt=\"Image\" title=\"Image\" style=\"text-decoration: none; -ms-interpolation-mode: bicubic; border: 0; height: auto; width: 100%; max-width: 600px; display: block;\" width=\"600\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]></td></tr></table><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<table class=\"divider\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;\" role=\"presentation\" valign=\"top\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t<tbody>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t<tr style=\"vertical-align: top;\" valign=\"top\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"divider_inner\" style=\"word-break: break-word; vertical-align: top; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%; padding-top: 30px; padding-right: 30px; padding-bottom: 30px; padding-left: 30px;\" valign=\"top\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<table class=\"divider_content\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-top: 0px solid transparent; width: 100%;\" align=\"center\" role=\"presentation\" valign=\"top\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tbody>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr style=\"vertical-align: top;\" valign=\"top\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td style=\"word-break: break-word; vertical-align: top; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;\" valign=\"top\"><span></span></td>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tbody>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</table>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t</tbody>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t</table>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<!--[if (!mso)&(!IE)]><!-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t\t\t<!--<![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]></td></tr></table></td></tr></table><![endif]-->\n" +
                        "\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n" +
                        "\t\t\t\t</td>\n" +
                        "\t\t\t</tr>\n" +
                        "\t\t</tbody>\n" +
                        "\t</table>\n" +
                        "\t<!--[if (IE)]></div><![endif]-->\n" +
                        "</body>\n" +
                        "\n" +
                        "</html>";

        return emailContent;
    }

    @Override
    public String mailResetPassword(PasswordResetToken token) {
        String emailContent =
                "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional //EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
                        "<html xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:v=\"urn:schemas-microsoft-com:vml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\">\n" +
                        "\n" +
                        "<head>\n" +
                        "\t<!--[if gte mso 9]><xml><o:OfficeDocumentSettings><o:AllowPNG/><o:PixelsPerInch>96</o:PixelsPerInch></o:OfficeDocumentSettings></xml><![endif]-->\n" +
                        "\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\n" +
                        "\t<meta name=\"viewport\" content=\"width=device-width\">\n" +
                        "\t<!--[if !mso]><!-->\n" +
                        "\t<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
                        "\t<!--<![endif]-->\n" +
                        "\t<title></title>\n" +
                        "\t<!--[if !mso]><!-->\n" +
                        "\t<link href=\"https://fonts.googleapis.com/css?family=Montserrat\" rel=\"stylesheet\" type=\"text/css\">\n" +
                        "\t<!--<![endif]-->\n" +
                        "\t<style type=\"text/css\">\n" +
                        "\t\tbody {\n" +
                        "\t\t\tmargin: 0;\n" +
                        "\t\t\tpadding: 0;\n" +
                        "\t\t}\n" +
                        "\n" +
                        "\t\ttable,\n" +
                        "\t\ttd,\n" +
                        "\t\ttr {\n" +
                        "\t\t\tvertical-align: top;\n" +
                        "\t\t\tborder-collapse: collapse;\n" +
                        "\t\t}\n" +
                        "\n" +
                        "\t\t* {\n" +
                        "\t\t\tline-height: inherit;\n" +
                        "\t\t}\n" +
                        "\n" +
                        "\t\ta[x-apple-data-detectors=true] {\n" +
                        "\t\t\tcolor: inherit !important;\n" +
                        "\t\t\ttext-decoration: none !important;\n" +
                        "\t\t}\n" +
                        "\t</style>\n" +
                        "\t<style type=\"text/css\" id=\"media-query\">\n" +
                        "\t\t@media (max-width: 620px) {\n" +
                        "\n" +
                        "\t\t\t.block-grid,\n" +
                        "\t\t\t.col {\n" +
                        "\t\t\t\tmin-width: 320px !important;\n" +
                        "\t\t\t\tmax-width: 100% !important;\n" +
                        "\t\t\t\tdisplay: block !important;\n" +
                        "\t\t\t}\n" +
                        "\n" +
                        "\t\t\t.block-grid {\n" +
                        "\t\t\t\twidth: 100% !important;\n" +
                        "\t\t\t}\n" +
                        "\n" +
                        "\t\t\t.col {\n" +
                        "\t\t\t\twidth: 100% !important;\n" +
                        "\t\t\t}\n" +
                        "\n" +
                        "\t\t\t.col>div {\n" +
                        "\t\t\t\tmargin: 0 auto;\n" +
                        "\t\t\t}\n" +
                        "\n" +
                        "\t\t\timg.fullwidth,\n" +
                        "\t\t\timg.fullwidthOnMobile {\n" +
                        "\t\t\t\tmax-width: 100% !important;\n" +
                        "\t\t\t}\n" +
                        "\n" +
                        "\t\t\t.no-stack .col {\n" +
                        "\t\t\t\tmin-width: 0 !important;\n" +
                        "\t\t\t\tdisplay: table-cell !important;\n" +
                        "\t\t\t}\n" +
                        "\n" +
                        "\t\t\t.no-stack.two-up .col {\n" +
                        "\t\t\t\twidth: 50% !important;\n" +
                        "\t\t\t}\n" +
                        "\n" +
                        "\t\t\t.no-stack .col.num4 {\n" +
                        "\t\t\t\twidth: 33% !important;\n" +
                        "\t\t\t}\n" +
                        "\n" +
                        "\t\t\t.no-stack .col.num8 {\n" +
                        "\t\t\t\twidth: 66% !important;\n" +
                        "\t\t\t}\n" +
                        "\n" +
                        "\t\t\t.no-stack .col.num4 {\n" +
                        "\t\t\t\twidth: 33% !important;\n" +
                        "\t\t\t}\n" +
                        "\n" +
                        "\t\t\t.no-stack .col.num3 {\n" +
                        "\t\t\t\twidth: 25% !important;\n" +
                        "\t\t\t}\n" +
                        "\n" +
                        "\t\t\t.no-stack .col.num6 {\n" +
                        "\t\t\t\twidth: 50% !important;\n" +
                        "\t\t\t}\n" +
                        "\n" +
                        "\t\t\t.no-stack .col.num9 {\n" +
                        "\t\t\t\twidth: 75% !important;\n" +
                        "\t\t\t}\n" +
                        "\n" +
                        "\t\t\t.video-block {\n" +
                        "\t\t\t\tmax-width: none !important;\n" +
                        "\t\t\t}\n" +
                        "\n" +
                        "\t\t\t.mobile_hide {\n" +
                        "\t\t\t\tmin-height: 0px;\n" +
                        "\t\t\t\tmax-height: 0px;\n" +
                        "\t\t\t\tmax-width: 0px;\n" +
                        "\t\t\t\tdisplay: none;\n" +
                        "\t\t\t\toverflow: hidden;\n" +
                        "\t\t\t\tfont-size: 0px;\n" +
                        "\t\t\t}\n" +
                        "\n" +
                        "\t\t\t.desktop_hide {\n" +
                        "\t\t\t\tdisplay: block !important;\n" +
                        "\t\t\t\tmax-height: none !important;\n" +
                        "\t\t\t}\n" +
                        "\t\t}\n" +
                        "\t</style>\n" +
                        "</head>\n" +
                        "\n" +
                        "<body class=\"clean-body\" style=\"margin: 0; padding: 0; -webkit-text-size-adjust: 100%; background-color: #e2eace;\">\n" +
                        "\t<!--[if IE]><div class=\"ie-browser\"><![endif]-->\n" +
                        "\t<table class=\"nl-container\" style=\"table-layout: fixed; vertical-align: top; min-width: 320px; Margin: 0 auto; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #e2eace; width: 100%;\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" width=\"100%\" bgcolor=\"#e2eace\" valign=\"top\">\n" +
                        "\t\t<tbody>\n" +
                        "\t\t\t<tr style=\"vertical-align: top;\" valign=\"top\">\n" +
                        "\t\t\t\t<td style=\"word-break: break-word; vertical-align: top;\" valign=\"top\">\n" +
                        "\t\t\t\t\t<!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td align=\"center\" style=\"background-color:#e2eace\"><![endif]-->\n" +
                        "\t\t\t\t\t<div style=\"background-color:transparent;\">\n" +
                        "\t\t\t\t\t\t<div class=\"block-grid \" style=\"Margin: 0 auto; min-width: 320px; max-width: 600px; overflow-wrap: break-word; word-wrap: break-word; word-break: break-word; background-color: transparent;\">\n" +
                        "\t\t\t\t\t\t\t<div style=\"border-collapse: collapse;display: table;width: 100%;background-color:transparent;\">\n" +
                        "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"background-color:transparent;\"><tr><td align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px\"><tr class=\"layout-full-width\" style=\"background-color:transparent\"><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]><td align=\"center\" width=\"600\" style=\"background-color:transparent;width:600px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top:5px; padding-bottom:0px;\"><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t<div class=\"col num12\" style=\"min-width: 320px; max-width: 600px; display: table-cell; vertical-align: top; width: 600px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t<div style=\"width:100% !important;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t<!--[if (!mso)&(!IE)]><!-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t<div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:5px; padding-bottom:0px; padding-right: 0px; padding-left: 0px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<!--<![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<div class=\"img-container center autowidth\" align=\"center\" style=\"padding-right: 0px;padding-left: 0px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr style=\"line-height:0px\"><td style=\"padding-right: 0px;padding-left: 0px;\" align=\"center\"><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"font-size:1px;line-height:25px\">&nbsp;</div><img class=\"center autowidth\" align=\"center\" border=\"0\" src=\"https://d1oco4z2z1fhwp.cloudfront.net/templates/default/20/rounder-up.png\" alt=\"Image\" title=\"Image\" style=\"text-decoration: none; -ms-interpolation-mode: bicubic; border: 0; height: auto; width: 100%; max-width: 600px; display: block;\" width=\"600\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]></td></tr></table><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<!--[if (!mso)&(!IE)]><!-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t\t\t<!--<![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]></td></tr></table></td></tr></table><![endif]-->\n" +
                        "\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t<div style=\"background-color:transparent;\">\n" +
                        "\t\t\t\t\t\t<div class=\"block-grid \" style=\"Margin: 0 auto; min-width: 320px; max-width: 600px; overflow-wrap: break-word; word-wrap: break-word; word-break: break-word; background-color: #FFFFFF;\">\n" +
                        "\t\t\t\t\t\t\t<div style=\"border-collapse: collapse;display: table;width: 100%;background-color:#FFFFFF;\">\n" +
                        "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"background-color:transparent;\"><tr><td align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px\"><tr class=\"layout-full-width\" style=\"background-color:#FFFFFF\"><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]><td align=\"center\" width=\"600\" style=\"background-color:#FFFFFF;width:600px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top:5px; padding-bottom:5px;\"><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t<div class=\"col num12\" style=\"min-width: 320px; max-width: 600px; display: table-cell; vertical-align: top; width: 600px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t<div style=\"width:100% !important;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t<!--[if (!mso)&(!IE)]><!-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t<div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:5px; padding-bottom:5px; padding-right: 0px; padding-left: 0px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<!--<![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<div class=\"img-container center\" align=\"center\" style=\"padding-right: 0px;padding-left: 0px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr style=\"line-height:0px\"><td style=\"padding-right: 0px;padding-left: 0px;\" align=\"center\"><![endif]--><img class=\"center\" align=\"center\" border=\"0\" src=\"https://media.licdn.com/dms/image/C561BAQFvBoDlloIR4w/company-background_10000/0?e=2159024400&amp;v=beta&amp;t=vmTY91FoP8rQRgvgePKIao5DgLbbV3pGjlLfFwHIwwM\" alt=\"Image\" title=\"Image\" style=\"text-decoration: none; -ms-interpolation-mode: bicubic; border: 0; height: auto; width: 100%; max-width: 360px; display: block;\" width=\"360\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]></td></tr></table><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 10px; padding-left: 10px; padding-top: 10px; padding-bottom: 10px; font-family: Tahoma, sans-serif\"><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<div style=\"color:#555555;font-family:Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif;line-height:1.5;padding-top:10px;padding-right:10px;padding-bottom:10px;padding-left:10px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"font-size: 12px; line-height: 1.5; color: #555555; font-family: Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif; mso-line-height-alt: 18px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t<p style=\"font-size: 14px; line-height: 1.5; text-align: center; word-break: break-word; mso-line-height-alt: 21px; margin: 0;\">Công Ty Cổ Phần Công Nghệ Và Truyền Thông VIS</p>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]></td></tr></table><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<!--[if (!mso)&(!IE)]><!-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t\t\t<!--<![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]></td></tr></table></td></tr></table><![endif]-->\n" +
                        "\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t<div style=\"background-color:transparent;\">\n" +
                        "\t\t\t\t\t\t<div class=\"block-grid \" style=\"Margin: 0 auto; min-width: 320px; max-width: 600px; overflow-wrap: break-word; word-wrap: break-word; word-break: break-word; background-color: #FFFFFF;\">\n" +
                        "\t\t\t\t\t\t\t<div style=\"border-collapse: collapse;display: table;width: 100%;background-color:#FFFFFF;\">\n" +
                        "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"background-color:transparent;\"><tr><td align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px\"><tr class=\"layout-full-width\" style=\"background-color:#FFFFFF\"><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]><td align=\"center\" width=\"600\" style=\"background-color:#FFFFFF;width:600px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top:0px; padding-bottom:5px;\"><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t<div class=\"col num12\" style=\"min-width: 320px; max-width: 600px; display: table-cell; vertical-align: top; width: 600px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t<div style=\"width:100% !important;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t<!--[if (!mso)&(!IE)]><!-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t<div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:0px; padding-bottom:5px; padding-right: 0px; padding-left: 0px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<!--<![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 10px; padding-left: 10px; padding-top: 10px; padding-bottom: 10px; font-family: Tahoma, sans-serif\"><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<div style=\"color:#0D0D0D;font-family:Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif;line-height:1.2;padding-top:10px;padding-right:10px;padding-bottom:10px;padding-left:10px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"font-size: 12px; line-height: 1.2; color: #0D0D0D; font-family: Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif; mso-line-height-alt: 14px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t<p style=\"font-size: 28px; line-height: 1.2; text-align: center; word-break: break-word; mso-line-height-alt: 34px; margin: 0;\"><span style=\"font-size: 28px;\"><strong>Lấy lại mật khẩu</strong></span></p>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]></td></tr></table><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<div class=\"img-container center\" align=\"center\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr style=\"line-height:0px\"><td style=\"\" align=\"center\"><![endif]--><img class=\"center\" align=\"center\" border=\"0\" src=\"https://d1oco4z2z1fhwp.cloudfront.net/templates/default/20/divider.png\" alt=\"Image\" title=\"Image\" style=\"text-decoration: none; -ms-interpolation-mode: bicubic; border: 0; height: auto; width: 100%; max-width: 318px; display: block;\" width=\"318\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]></td></tr></table><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 10px; padding-left: 10px; padding-top: 10px; padding-bottom: 10px; font-family: Tahoma, sans-serif\"><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<div style=\"color:#555555;font-family:Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif;line-height:1.5;padding-top:10px;padding-right:10px;padding-bottom:10px;padding-left:10px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"font-size: 12px; line-height: 1.5; color: #555555; font-family: Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif; mso-line-height-alt: 18px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t<p style=\"font-size: 14px; line-height: 1.5; text-align: center; word-break: break-word; mso-line-height-alt: 21px; margin: 0;\"><span style=\"color: #a8bf6f; font-size: 14px;\"><strong>Chào anh/chị!</strong></span></p>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t<p style=\"font-size: 14px; line-height: 1.5; text-align: center; word-break: break-word; mso-line-height-alt: 21px; margin: 0;\"><span style=\"color: #a8bf6f; font-size: 14px;\"><strong>Anh/chị vui lòng click vào nút bên dưới để lấy lại mật khẩu bị mất!</strong></span></p>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]></td></tr></table><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 10px; padding-left: 10px; padding-top: 20px; padding-bottom: 10px; font-family: Tahoma, sans-serif\"><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<div style=\"color:#0D0D0D;font-family:Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif;line-height:1.5;padding-top:20px;padding-right:10px;padding-bottom:10px;padding-left:10px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"line-height: 1.5; font-size: 12px; color: #0D0D0D; font-family: Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif; mso-line-height-alt: 18px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]></td></tr></table><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<div class=\"button-container\" align=\"center\" style=\"padding-top:25px;padding-right:10px;padding-bottom:10px;padding-left:10px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"border-spacing: 0; border-collapse: collapse; mso-table-lspace:0pt; mso-table-rspace:0pt;\"><tr><td style=\"padding-top: 25px; padding-right: 10px; padding-bottom: 10px; padding-left: 10px\" align=\"center\"><v:roundrect xmlns:v=\"urn:schemas-microsoft-com:vml\" xmlns:w=\"urn:schemas-microsoft-com:office:word\" href=\"http://14.225.5.246:8864/#/reset-password?token=" + token.getToken() +"\" style=\"height:46.5pt; width:100.5pt; v-text-anchor:middle;\" arcsize=\"7%\" stroke=\"false\" fillcolor=\"#a8bf6f\"><w:anchorlock/><v:textbox inset=\"0,0,0,0\"><center style=\"color:#ffffff; font-family:Tahoma, sans-serif; font-size:16px\"><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t<a href=\"http://14.225.5.246:8864/#/reset-password?token=" + token.getToken() +"\" target=\"_blank\" style=\"-webkit-text-size-adjust: none; text-decoration: none; display: inline-block; color: #ffffff; background-color: #a8bf6f; border-radius: 4px; -webkit-border-radius: 4px; -moz-border-radius: 4px; width: auto; width: auto; border-top: 1px solid #a8bf6f; border-right: 1px solid #a8bf6f; border-bottom: 1px solid #a8bf6f; border-left: 1px solid #a8bf6f; padding-top: 15px; padding-bottom: 15px; font-family: Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif; text-align: center; mso-border-alt: none; word-break: keep-all;\"><span style=\"padding-left:15px;padding-right:15px;font-size:16px;display:inline-block;\"><span style=\"font-size: 16px; line-height: 2; word-break: break-word; mso-line-height-alt: 32px;\">Đổi mật khẩu</span></span></a>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]></center></v:textbox></v:roundrect></td></tr></table><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<table class=\"divider\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;\" role=\"presentation\" valign=\"top\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t<tbody>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t<tr style=\"vertical-align: top;\" valign=\"top\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"divider_inner\" style=\"word-break: break-word; vertical-align: top; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%; padding-top: 30px; padding-right: 10px; padding-bottom: 10px; padding-left: 10px;\" valign=\"top\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<table class=\"divider_content\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-top: 0px solid transparent; width: 100%;\" align=\"center\" role=\"presentation\" valign=\"top\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tbody>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr style=\"vertical-align: top;\" valign=\"top\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td style=\"word-break: break-word; vertical-align: top; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;\" valign=\"top\"><span></span></td>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tbody>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</table>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t</tbody>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t</table>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<!--[if (!mso)&(!IE)]><!-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t\t\t<!--<![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]></td></tr></table></td></tr></table><![endif]-->\n" +
                        "\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t<div style=\"background-color:transparent;\">\n" +
                        "\t\t\t\t\t\t<div class=\"block-grid three-up\" style=\"Margin: 0 auto; min-width: 320px; max-width: 600px; overflow-wrap: break-word; word-wrap: break-word; word-break: break-word; background-color: #525252;\">\n" +
                        "\t\t\t\t\t\t\t<div style=\"border-collapse: collapse;display: table;width: 100%;background-color:#525252;\">\n" +
                        "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"background-color:transparent;\"><tr><td align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px\"><tr class=\"layout-full-width\" style=\"background-color:#525252\"><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]><td align=\"center\" width=\"200\" style=\"background-color:#525252;width:200px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top:0px; padding-bottom:0px;\"><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t<div class=\"col num4\" style=\"max-width: 320px; min-width: 200px; display: table-cell; vertical-align: top; width: 200px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t<div style=\"width:100% !important;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t<!--[if (!mso)&(!IE)]><!-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t<div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:0px; padding-bottom:0px; padding-right: 0px; padding-left: 0px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<!--<![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<table class=\"social_icons\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" role=\"presentation\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" valign=\"top\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t<tbody>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t<tr style=\"vertical-align: top;\" valign=\"top\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td style=\"word-break: break-word; vertical-align: top; padding-top: 15px; padding-right: 0px; padding-bottom: 0px; padding-left: 0px;\" valign=\"top\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<table class=\"social_table\" align=\"center\" to=\"to\" activate=\"activate\" alignment=\"alignment\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: undefined; mso-table-tspace: 0; mso-table-rspace: 0; mso-table-bspace: 0; mso-table-lspace: 0;\" valign=\"top\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tbody>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr style=\"vertical-align: top; display: inline-block; text-align: center;\" align=\"center\" valign=\"top\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td style=\"word-break: break-word; vertical-align: top; padding-bottom: 5px; padding-right: 3px; padding-left: 3px;\" valign=\"top\"><a href=\"http://vissoft.vn\" target=\"_blank\"><img width=\"32\" height=\"32\" src=\"https://d2fi4ri5dhpqd1.cloudfront.net/public/resources/social-networks-icon-sets/t-only-logo-default-gray/facebook@2x.png\" alt=\"Facebook\" title=\"Facebook\" style=\"text-decoration: none; -ms-interpolation-mode: bicubic; height: auto; border: none; display: block;\"></a></td>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td style=\"word-break: break-word; vertical-align: top; padding-bottom: 5px; padding-right: 3px; padding-left: 3px;\" valign=\"top\"><a href=\"http://vissoft.vn\" target=\"_blank\"><img width=\"32\" height=\"32\" src=\"https://d2fi4ri5dhpqd1.cloudfront.net/public/resources/social-networks-icon-sets/t-only-logo-default-gray/twitter@2x.png\" alt=\"Twitter\" title=\"Twitter\" style=\"text-decoration: none; -ms-interpolation-mode: bicubic; height: auto; border: none; display: block;\"></a></td>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td style=\"word-break: break-word; vertical-align: top; padding-bottom: 5px; padding-right: 3px; padding-left: 3px;\" valign=\"top\"><a href=\"http://vissoft.vn\" target=\"_blank\"><img width=\"32\" height=\"32\" src=\"https://d2fi4ri5dhpqd1.cloudfront.net/public/resources/social-networks-icon-sets/t-only-logo-default-gray/googleplus@2x.png\" alt=\"Google+\" title=\"Google+\" style=\"text-decoration: none; -ms-interpolation-mode: bicubic; height: auto; border: none; display: block;\"></a></td>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tbody>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</table>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t</tbody>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t</table>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<!--[if (!mso)&(!IE)]><!-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t\t\t<!--<![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]></td><td align=\"center\" width=\"200\" style=\"background-color:#525252;width:200px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top:5px; padding-bottom:5px;\"><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t<div class=\"col num4\" style=\"max-width: 320px; min-width: 200px; display: table-cell; vertical-align: top; width: 200px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t<div style=\"width:100% !important;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t<!--[if (!mso)&(!IE)]><!-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t<div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:5px; padding-bottom:5px; padding-right: 0px; padding-left: 0px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<!--<![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top: 20px; padding-bottom: 0px; font-family: Tahoma, sans-serif\"><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<div style=\"color:#a8bf6f;font-family:Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif;line-height:1.2;padding-top:20px;padding-right:0px;padding-bottom:0px;padding-left:0px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"font-size: 12px; line-height: 1.2; color: #a8bf6f; font-family: Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif; mso-line-height-alt: 14px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t<p style=\"font-size: 12px; line-height: 1.2; text-align: center; word-break: break-word; mso-line-height-alt: 14px; margin: 0;\"><span style=\"color: #ffffff; font-size: 12px;\"><span style=\"font-size: 12px; color: #a8bf6f;\">Tel.:</span> +(024) - 666 20346</span></p>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]></td></tr></table><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<!--[if (!mso)&(!IE)]><!-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t\t\t<!--<![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]></td><td align=\"center\" width=\"200\" style=\"background-color:#525252;width:200px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top:5px; padding-bottom:5px;\"><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t<div class=\"col num4\" style=\"max-width: 320px; min-width: 200px; display: table-cell; vertical-align: top; width: 200px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t<div style=\"width:100% !important;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t<!--[if (!mso)&(!IE)]><!-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t<div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:5px; padding-bottom:5px; padding-right: 0px; padding-left: 0px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<!--<![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top: 20px; padding-bottom: 0px; font-family: Tahoma, sans-serif\"><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<div style=\"color:#a8bf6f;font-family:Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif;line-height:1.2;padding-top:20px;padding-right:0px;padding-bottom:0px;padding-left:0px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"font-size: 12px; line-height: 1.2; color: #a8bf6f; font-family: Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif; mso-line-height-alt: 14px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t<p style=\"font-size: 12px; line-height: 1.2; text-align: center; word-break: break-word; mso-line-height-alt: 14px; margin: 0;\">Email <span style=\"color: #ffffff; font-size: 12px;\">contact@vissoft.vn</span></p>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]></td></tr></table><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<!--[if (!mso)&(!IE)]><!-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t\t\t<!--<![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]></td></tr></table></td></tr></table><![endif]-->\n" +
                        "\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t<div style=\"background-color:transparent;\">\n" +
                        "\t\t\t\t\t\t<div class=\"block-grid \" style=\"Margin: 0 auto; min-width: 320px; max-width: 600px; overflow-wrap: break-word; word-wrap: break-word; word-break: break-word; background-color: transparent;\">\n" +
                        "\t\t\t\t\t\t\t<div style=\"border-collapse: collapse;display: table;width: 100%;background-color:transparent;\">\n" +
                        "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"background-color:transparent;\"><tr><td align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px\"><tr class=\"layout-full-width\" style=\"background-color:transparent\"><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]><td align=\"center\" width=\"600\" style=\"background-color:transparent;width:600px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top:0px; padding-bottom:5px;\"><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t<div class=\"col num12\" style=\"min-width: 320px; max-width: 600px; display: table-cell; vertical-align: top; width: 600px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t<div style=\"width:100% !important;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t<!--[if (!mso)&(!IE)]><!-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t<div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:0px; padding-bottom:5px; padding-right: 0px; padding-left: 0px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<!--<![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<div class=\"img-container center autowidth\" align=\"center\" style=\"padding-right: 0px;padding-left: 0px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr style=\"line-height:0px\"><td style=\"padding-right: 0px;padding-left: 0px;\" align=\"center\"><![endif]--><img class=\"center autowidth\" align=\"center\" border=\"0\" src=\"https://d1oco4z2z1fhwp.cloudfront.net/templates/default/20/rounder-dwn.png\" alt=\"Image\" title=\"Image\" style=\"text-decoration: none; -ms-interpolation-mode: bicubic; border: 0; height: auto; width: 100%; max-width: 600px; display: block;\" width=\"600\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]></td></tr></table><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<table class=\"divider\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;\" role=\"presentation\" valign=\"top\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t<tbody>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t<tr style=\"vertical-align: top;\" valign=\"top\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"divider_inner\" style=\"word-break: break-word; vertical-align: top; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%; padding-top: 30px; padding-right: 30px; padding-bottom: 30px; padding-left: 30px;\" valign=\"top\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<table class=\"divider_content\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-top: 0px solid transparent; width: 100%;\" align=\"center\" role=\"presentation\" valign=\"top\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tbody>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr style=\"vertical-align: top;\" valign=\"top\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td style=\"word-break: break-word; vertical-align: top; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;\" valign=\"top\"><span></span></td>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tbody>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</table>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t</tbody>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t</table>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<!--[if (!mso)&(!IE)]><!-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t\t\t<!--<![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]></td></tr></table></td></tr></table><![endif]-->\n" +
                        "\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n" +
                        "\t\t\t\t</td>\n" +
                        "\t\t\t</tr>\n" +
                        "\t\t</tbody>\n" +
                        "\t</table>\n" +
                        "\t<!--[if (IE)]></div><![endif]-->\n" +
                        "</body>\n" +
                        "\n" +
                        "</html>";

        return emailContent;
    }

    @Override
    public String mailEvaluateKPI() {
        String emailContent =
                "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional //EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
                        "<html xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:v=\"urn:schemas-microsoft-com:vml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\">\n" +
                        "\n" +
                        "<head>\n" +
                        "\t<!--[if gte mso 9]><xml><o:OfficeDocumentSettings><o:AllowPNG/><o:PixelsPerInch>96</o:PixelsPerInch></o:OfficeDocumentSettings></xml><![endif]-->\n" +
                        "\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\n" +
                        "\t<meta name=\"viewport\" content=\"width=device-width\">\n" +
                        "\t<!--[if !mso]><!-->\n" +
                        "\t<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
                        "\t<!--<![endif]-->\n" +
                        "\t<title></title>\n" +
                        "\t<!--[if !mso]><!-->\n" +
                        "\t<link href=\"https://fonts.googleapis.com/css?family=Montserrat\" rel=\"stylesheet\" type=\"text/css\">\n" +
                        "\t<!--<![endif]-->\n" +
                        "\t<style type=\"text/css\">\n" +
                        "\t\tbody {\n" +
                        "\t\t\tmargin: 0;\n" +
                        "\t\t\tpadding: 0;\n" +
                        "\t\t}\n" +
                        "\n" +
                        "\t\ttable,\n" +
                        "\t\ttd,\n" +
                        "\t\ttr {\n" +
                        "\t\t\tvertical-align: top;\n" +
                        "\t\t\tborder-collapse: collapse;\n" +
                        "\t\t}\n" +
                        "\n" +
                        "\t\t* {\n" +
                        "\t\t\tline-height: inherit;\n" +
                        "\t\t}\n" +
                        "\n" +
                        "\t\ta[x-apple-data-detectors=true] {\n" +
                        "\t\t\tcolor: inherit !important;\n" +
                        "\t\t\ttext-decoration: none !important;\n" +
                        "\t\t}\n" +
                        "\t</style>\n" +
                        "\t<style type=\"text/css\" id=\"media-query\">\n" +
                        "\t\t@media (max-width: 620px) {\n" +
                        "\n" +
                        "\t\t\t.block-grid,\n" +
                        "\t\t\t.col {\n" +
                        "\t\t\t\tmin-width: 320px !important;\n" +
                        "\t\t\t\tmax-width: 100% !important;\n" +
                        "\t\t\t\tdisplay: block !important;\n" +
                        "\t\t\t}\n" +
                        "\n" +
                        "\t\t\t.block-grid {\n" +
                        "\t\t\t\twidth: 100% !important;\n" +
                        "\t\t\t}\n" +
                        "\n" +
                        "\t\t\t.col {\n" +
                        "\t\t\t\twidth: 100% !important;\n" +
                        "\t\t\t}\n" +
                        "\n" +
                        "\t\t\t.col>div {\n" +
                        "\t\t\t\tmargin: 0 auto;\n" +
                        "\t\t\t}\n" +
                        "\n" +
                        "\t\t\timg.fullwidth,\n" +
                        "\t\t\timg.fullwidthOnMobile {\n" +
                        "\t\t\t\tmax-width: 100% !important;\n" +
                        "\t\t\t}\n" +
                        "\n" +
                        "\t\t\t.no-stack .col {\n" +
                        "\t\t\t\tmin-width: 0 !important;\n" +
                        "\t\t\t\tdisplay: table-cell !important;\n" +
                        "\t\t\t}\n" +
                        "\n" +
                        "\t\t\t.no-stack.two-up .col {\n" +
                        "\t\t\t\twidth: 50% !important;\n" +
                        "\t\t\t}\n" +
                        "\n" +
                        "\t\t\t.no-stack .col.num4 {\n" +
                        "\t\t\t\twidth: 33% !important;\n" +
                        "\t\t\t}\n" +
                        "\n" +
                        "\t\t\t.no-stack .col.num8 {\n" +
                        "\t\t\t\twidth: 66% !important;\n" +
                        "\t\t\t}\n" +
                        "\n" +
                        "\t\t\t.no-stack .col.num4 {\n" +
                        "\t\t\t\twidth: 33% !important;\n" +
                        "\t\t\t}\n" +
                        "\n" +
                        "\t\t\t.no-stack .col.num3 {\n" +
                        "\t\t\t\twidth: 25% !important;\n" +
                        "\t\t\t}\n" +
                        "\n" +
                        "\t\t\t.no-stack .col.num6 {\n" +
                        "\t\t\t\twidth: 50% !important;\n" +
                        "\t\t\t}\n" +
                        "\n" +
                        "\t\t\t.no-stack .col.num9 {\n" +
                        "\t\t\t\twidth: 75% !important;\n" +
                        "\t\t\t}\n" +
                        "\n" +
                        "\t\t\t.video-block {\n" +
                        "\t\t\t\tmax-width: none !important;\n" +
                        "\t\t\t}\n" +
                        "\n" +
                        "\t\t\t.mobile_hide {\n" +
                        "\t\t\t\tmin-height: 0px;\n" +
                        "\t\t\t\tmax-height: 0px;\n" +
                        "\t\t\t\tmax-width: 0px;\n" +
                        "\t\t\t\tdisplay: none;\n" +
                        "\t\t\t\toverflow: hidden;\n" +
                        "\t\t\t\tfont-size: 0px;\n" +
                        "\t\t\t}\n" +
                        "\n" +
                        "\t\t\t.desktop_hide {\n" +
                        "\t\t\t\tdisplay: block !important;\n" +
                        "\t\t\t\tmax-height: none !important;\n" +
                        "\t\t\t}\n" +
                        "\t\t}\n" +
                        "\t</style>\n" +
                        "</head>\n" +
                        "\n" +
                        "<body class=\"clean-body\" style=\"margin: 0; padding: 0; -webkit-text-size-adjust: 100%; background-color: #e2eace;\">\n" +
                        "\t<!--[if IE]><div class=\"ie-browser\"><![endif]-->\n" +
                        "\t<table class=\"nl-container\" style=\"table-layout: fixed; vertical-align: top; min-width: 320px; Margin: 0 auto; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #e2eace; width: 100%;\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" width=\"100%\" bgcolor=\"#e2eace\" valign=\"top\">\n" +
                        "\t\t<tbody>\n" +
                        "\t\t\t<tr style=\"vertical-align: top;\" valign=\"top\">\n" +
                        "\t\t\t\t<td style=\"word-break: break-word; vertical-align: top;\" valign=\"top\">\n" +
                        "\t\t\t\t\t<!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td align=\"center\" style=\"background-color:#e2eace\"><![endif]-->\n" +
                        "\t\t\t\t\t<div style=\"background-color:transparent;\">\n" +
                        "\t\t\t\t\t\t<div class=\"block-grid \" style=\"Margin: 0 auto; min-width: 320px; max-width: 600px; overflow-wrap: break-word; word-wrap: break-word; word-break: break-word; background-color: transparent;\">\n" +
                        "\t\t\t\t\t\t\t<div style=\"border-collapse: collapse;display: table;width: 100%;background-color:transparent;\">\n" +
                        "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"background-color:transparent;\"><tr><td align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px\"><tr class=\"layout-full-width\" style=\"background-color:transparent\"><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]><td align=\"center\" width=\"600\" style=\"background-color:transparent;width:600px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top:5px; padding-bottom:0px;\"><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t<div class=\"col num12\" style=\"min-width: 320px; max-width: 600px; display: table-cell; vertical-align: top; width: 600px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t<div style=\"width:100% !important;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t<!--[if (!mso)&(!IE)]><!-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t<div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:5px; padding-bottom:0px; padding-right: 0px; padding-left: 0px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<!--<![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<div class=\"img-container center autowidth\" align=\"center\" style=\"padding-right: 0px;padding-left: 0px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr style=\"line-height:0px\"><td style=\"padding-right: 0px;padding-left: 0px;\" align=\"center\"><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"font-size:1px;line-height:25px\">&nbsp;</div><img class=\"center autowidth\" align=\"center\" border=\"0\" src=\"https://d1oco4z2z1fhwp.cloudfront.net/templates/default/20/rounder-up.png\" alt=\"Image\" title=\"Image\" style=\"text-decoration: none; -ms-interpolation-mode: bicubic; border: 0; height: auto; width: 100%; max-width: 600px; display: block;\" width=\"600\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]></td></tr></table><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<!--[if (!mso)&(!IE)]><!-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t\t\t<!--<![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]></td></tr></table></td></tr></table><![endif]-->\n" +
                        "\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t<div style=\"background-color:transparent;\">\n" +
                        "\t\t\t\t\t\t<div class=\"block-grid \" style=\"Margin: 0 auto; min-width: 320px; max-width: 600px; overflow-wrap: break-word; word-wrap: break-word; word-break: break-word; background-color: #FFFFFF;\">\n" +
                        "\t\t\t\t\t\t\t<div style=\"border-collapse: collapse;display: table;width: 100%;background-color:#FFFFFF;\">\n" +
                        "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"background-color:transparent;\"><tr><td align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px\"><tr class=\"layout-full-width\" style=\"background-color:#FFFFFF\"><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]><td align=\"center\" width=\"600\" style=\"background-color:#FFFFFF;width:600px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top:5px; padding-bottom:5px;\"><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t<div class=\"col num12\" style=\"min-width: 320px; max-width: 600px; display: table-cell; vertical-align: top; width: 600px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t<div style=\"width:100% !important;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t<!--[if (!mso)&(!IE)]><!-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t<div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:5px; padding-bottom:5px; padding-right: 0px; padding-left: 0px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<!--<![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<div class=\"img-container center\" align=\"center\" style=\"padding-right: 0px;padding-left: 0px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr style=\"line-height:0px\"><td style=\"padding-right: 0px;padding-left: 0px;\" align=\"center\"><![endif]--><img class=\"center\" align=\"center\" border=\"0\" src=\"https://media.licdn.com/dms/image/C561BAQFvBoDlloIR4w/company-background_10000/0?e=2159024400&amp;v=beta&amp;t=vmTY91FoP8rQRgvgePKIao5DgLbbV3pGjlLfFwHIwwM\" alt=\"Image\" title=\"Image\" style=\"text-decoration: none; -ms-interpolation-mode: bicubic; border: 0; height: auto; width: 100%; max-width: 360px; display: block;\" width=\"360\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]></td></tr></table><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 10px; padding-left: 10px; padding-top: 10px; padding-bottom: 10px; font-family: Tahoma, sans-serif\"><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<div style=\"color:#555555;font-family:Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif;line-height:1.5;padding-top:10px;padding-right:10px;padding-bottom:10px;padding-left:10px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"font-size: 12px; line-height: 1.5; color: #555555; font-family: Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif; mso-line-height-alt: 18px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t<p style=\"font-size: 14px; line-height: 1.5; text-align: center; word-break: break-word; mso-line-height-alt: 21px; margin: 0;\">Công Ty Cổ Phần Công Nghệ Và Truyền Thông VIS</p>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]></td></tr></table><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<!--[if (!mso)&(!IE)]><!-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t\t\t<!--<![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]></td></tr></table></td></tr></table><![endif]-->\n" +
                        "\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t<div style=\"background-color:transparent;\">\n" +
                        "\t\t\t\t\t\t<div class=\"block-grid \" style=\"Margin: 0 auto; min-width: 320px; max-width: 600px; overflow-wrap: break-word; word-wrap: break-word; word-break: break-word; background-color: #FFFFFF;\">\n" +
                        "\t\t\t\t\t\t\t<div style=\"border-collapse: collapse;display: table;width: 100%;background-color:#FFFFFF;\">\n" +
                        "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"background-color:transparent;\"><tr><td align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px\"><tr class=\"layout-full-width\" style=\"background-color:#FFFFFF\"><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]><td align=\"center\" width=\"600\" style=\"background-color:#FFFFFF;width:600px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top:0px; padding-bottom:5px;\"><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t<div class=\"col num12\" style=\"min-width: 320px; max-width: 600px; display: table-cell; vertical-align: top; width: 600px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t<div style=\"width:100% !important;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t<!--[if (!mso)&(!IE)]><!-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t<div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:0px; padding-bottom:5px; padding-right: 0px; padding-left: 0px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<!--<![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 10px; padding-left: 10px; padding-top: 10px; padding-bottom: 10px; font-family: Tahoma, sans-serif\"><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<div style=\"color:#0D0D0D;font-family:Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif;line-height:1.2;padding-top:10px;padding-right:10px;padding-bottom:10px;padding-left:10px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"font-size: 12px; line-height: 1.2; color: #0D0D0D; font-family: Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif; mso-line-height-alt: 14px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t<p style=\"font-size: 28px; line-height: 1.2; text-align: center; word-break: break-word; mso-line-height-alt: 34px; margin: 0;\"><span style=\"font-size: 28px;\"><strong>Đánh giá KPI hàng tháng</strong></span></p>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]></td></tr></table><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<div class=\"img-container center\" align=\"center\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr style=\"line-height:0px\"><td style=\"\" align=\"center\"><![endif]--><img class=\"center\" align=\"center\" border=\"0\" src=\"https://d1oco4z2z1fhwp.cloudfront.net/templates/default/20/divider.png\" alt=\"Image\" title=\"Image\" style=\"text-decoration: none; -ms-interpolation-mode: bicubic; border: 0; height: auto; width: 100%; max-width: 318px; display: block;\" width=\"318\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]></td></tr></table><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 10px; padding-left: 10px; padding-top: 10px; padding-bottom: 10px; font-family: Tahoma, sans-serif\"><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<div style=\"color:#555555;font-family:Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif;line-height:1.5;padding-top:10px;padding-right:10px;padding-bottom:10px;padding-left:10px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"font-size: 12px; line-height: 1.5; color: #555555; font-family: Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif; mso-line-height-alt: 18px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t<p style=\"font-size: 14px; line-height: 1.5; text-align: center; word-break: break-word; mso-line-height-alt: 21px; margin: 0;\"><span style=\"color: #a8bf6f; font-size: 14px;\"><strong>Chào anh/chị!</strong></span></p>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t<p style=\"font-size: 14px; line-height: 1.5; text-align: center; word-break: break-word; mso-line-height-alt: 21px; margin: 0;\"><span style=\"color: #a8bf6f; font-size: 14px;\"><strong>Anh/chị vui lòng click vào nút bên dưới để đánh giá KPI của tháng trước!</strong></span></p>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]></td></tr></table><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 10px; padding-left: 10px; padding-top: 20px; padding-bottom: 10px; font-family: Tahoma, sans-serif\"><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<div style=\"color:#0D0D0D;font-family:Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif;line-height:1.5;padding-top:20px;padding-right:10px;padding-bottom:10px;padding-left:10px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"line-height: 1.5; font-size: 12px; color: #0D0D0D; font-family: Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif; mso-line-height-alt: 18px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]></td></tr></table><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<div class=\"button-container\" align=\"center\" style=\"padding-top:25px;padding-right:10px;padding-bottom:10px;padding-left:10px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"border-spacing: 0; border-collapse: collapse; mso-table-lspace:0pt; mso-table-rspace:0pt;\"><tr><td style=\"padding-top: 25px; padding-right: 10px; padding-bottom: 10px; padding-left: 10px\" align=\"center\"><v:roundrect xmlns:v=\"urn:schemas-microsoft-com:vml\" xmlns:w=\"urn:schemas-microsoft-com:office:word\" href=\"http://14.225.5.246:8864/#/evaluateKPI-management" +"\" style=\"height:46.5pt; width:100.5pt; v-text-anchor:middle;\" arcsize=\"7%\" stroke=\"false\" fillcolor=\"#a8bf6f\"><w:anchorlock/><v:textbox inset=\"0,0,0,0\"><center style=\"color:#ffffff; font-family:Tahoma, sans-serif; font-size:16px\"><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t<a href=\"http://14.225.5.246:8864/#/evaluateKPI-management"+"\" target=\"_blank\" style=\"-webkit-text-size-adjust: none; text-decoration: none; display: inline-block; color: #ffffff; background-color: #a8bf6f; border-radius: 4px; -webkit-border-radius: 4px; -moz-border-radius: 4px; width: auto; width: auto; border-top: 1px solid #a8bf6f; border-right: 1px solid #a8bf6f; border-bottom: 1px solid #a8bf6f; border-left: 1px solid #a8bf6f; padding-top: 15px; padding-bottom: 15px; font-family: Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif; text-align: center; mso-border-alt: none; word-break: keep-all;\"><span style=\"padding-left:15px;padding-right:15px;font-size:16px;display:inline-block;\"><span style=\"font-size: 16px; line-height: 2; word-break: break-word; mso-line-height-alt: 32px;\">Đánh giá KPI</span></span></a>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]></center></v:textbox></v:roundrect></td></tr></table><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<table class=\"divider\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;\" role=\"presentation\" valign=\"top\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t<tbody>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t<tr style=\"vertical-align: top;\" valign=\"top\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"divider_inner\" style=\"word-break: break-word; vertical-align: top; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%; padding-top: 30px; padding-right: 10px; padding-bottom: 10px; padding-left: 10px;\" valign=\"top\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<table class=\"divider_content\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-top: 0px solid transparent; width: 100%;\" align=\"center\" role=\"presentation\" valign=\"top\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tbody>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr style=\"vertical-align: top;\" valign=\"top\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td style=\"word-break: break-word; vertical-align: top; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;\" valign=\"top\"><span></span></td>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tbody>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</table>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t</tbody>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t</table>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<!--[if (!mso)&(!IE)]><!-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t\t\t<!--<![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]></td></tr></table></td></tr></table><![endif]-->\n" +
                        "\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t<div style=\"background-color:transparent;\">\n" +
                        "\t\t\t\t\t\t<div class=\"block-grid three-up\" style=\"Margin: 0 auto; min-width: 320px; max-width: 600px; overflow-wrap: break-word; word-wrap: break-word; word-break: break-word; background-color: #525252;\">\n" +
                        "\t\t\t\t\t\t\t<div style=\"border-collapse: collapse;display: table;width: 100%;background-color:#525252;\">\n" +
                        "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"background-color:transparent;\"><tr><td align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px\"><tr class=\"layout-full-width\" style=\"background-color:#525252\"><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]><td align=\"center\" width=\"200\" style=\"background-color:#525252;width:200px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top:0px; padding-bottom:0px;\"><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t<div class=\"col num4\" style=\"max-width: 320px; min-width: 200px; display: table-cell; vertical-align: top; width: 200px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t<div style=\"width:100% !important;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t<!--[if (!mso)&(!IE)]><!-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t<div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:0px; padding-bottom:0px; padding-right: 0px; padding-left: 0px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<!--<![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<table class=\"social_icons\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" role=\"presentation\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" valign=\"top\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t<tbody>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t<tr style=\"vertical-align: top;\" valign=\"top\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td style=\"word-break: break-word; vertical-align: top; padding-top: 15px; padding-right: 0px; padding-bottom: 0px; padding-left: 0px;\" valign=\"top\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<table class=\"social_table\" align=\"center\" to=\"to\" activate=\"activate\" alignment=\"alignment\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: undefined; mso-table-tspace: 0; mso-table-rspace: 0; mso-table-bspace: 0; mso-table-lspace: 0;\" valign=\"top\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tbody>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr style=\"vertical-align: top; display: inline-block; text-align: center;\" align=\"center\" valign=\"top\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td style=\"word-break: break-word; vertical-align: top; padding-bottom: 5px; padding-right: 3px; padding-left: 3px;\" valign=\"top\"><a href=\"http://vissoft.vn\" target=\"_blank\"><img width=\"32\" height=\"32\" src=\"https://d2fi4ri5dhpqd1.cloudfront.net/public/resources/social-networks-icon-sets/t-only-logo-default-gray/facebook@2x.png\" alt=\"Facebook\" title=\"Facebook\" style=\"text-decoration: none; -ms-interpolation-mode: bicubic; height: auto; border: none; display: block;\"></a></td>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td style=\"word-break: break-word; vertical-align: top; padding-bottom: 5px; padding-right: 3px; padding-left: 3px;\" valign=\"top\"><a href=\"http://vissoft.vn\" target=\"_blank\"><img width=\"32\" height=\"32\" src=\"https://d2fi4ri5dhpqd1.cloudfront.net/public/resources/social-networks-icon-sets/t-only-logo-default-gray/twitter@2x.png\" alt=\"Twitter\" title=\"Twitter\" style=\"text-decoration: none; -ms-interpolation-mode: bicubic; height: auto; border: none; display: block;\"></a></td>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td style=\"word-break: break-word; vertical-align: top; padding-bottom: 5px; padding-right: 3px; padding-left: 3px;\" valign=\"top\"><a href=\"http://vissoft.vn\" target=\"_blank\"><img width=\"32\" height=\"32\" src=\"https://d2fi4ri5dhpqd1.cloudfront.net/public/resources/social-networks-icon-sets/t-only-logo-default-gray/googleplus@2x.png\" alt=\"Google+\" title=\"Google+\" style=\"text-decoration: none; -ms-interpolation-mode: bicubic; height: auto; border: none; display: block;\"></a></td>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tbody>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</table>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t</tbody>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t</table>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<!--[if (!mso)&(!IE)]><!-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t\t\t<!--<![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]></td><td align=\"center\" width=\"200\" style=\"background-color:#525252;width:200px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top:5px; padding-bottom:5px;\"><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t<div class=\"col num4\" style=\"max-width: 320px; min-width: 200px; display: table-cell; vertical-align: top; width: 200px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t<div style=\"width:100% !important;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t<!--[if (!mso)&(!IE)]><!-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t<div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:5px; padding-bottom:5px; padding-right: 0px; padding-left: 0px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<!--<![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top: 20px; padding-bottom: 0px; font-family: Tahoma, sans-serif\"><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<div style=\"color:#a8bf6f;font-family:Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif;line-height:1.2;padding-top:20px;padding-right:0px;padding-bottom:0px;padding-left:0px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"font-size: 12px; line-height: 1.2; color: #a8bf6f; font-family: Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif; mso-line-height-alt: 14px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t<p style=\"font-size: 12px; line-height: 1.2; text-align: center; word-break: break-word; mso-line-height-alt: 14px; margin: 0;\"><span style=\"color: #ffffff; font-size: 12px;\"><span style=\"font-size: 12px; color: #a8bf6f;\">Tel.:</span> +(024) - 666 20346</span></p>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]></td></tr></table><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<!--[if (!mso)&(!IE)]><!-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t\t\t<!--<![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]></td><td align=\"center\" width=\"200\" style=\"background-color:#525252;width:200px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top:5px; padding-bottom:5px;\"><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t<div class=\"col num4\" style=\"max-width: 320px; min-width: 200px; display: table-cell; vertical-align: top; width: 200px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t<div style=\"width:100% !important;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t<!--[if (!mso)&(!IE)]><!-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t<div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:5px; padding-bottom:5px; padding-right: 0px; padding-left: 0px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<!--<![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top: 20px; padding-bottom: 0px; font-family: Tahoma, sans-serif\"><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<div style=\"color:#a8bf6f;font-family:Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif;line-height:1.2;padding-top:20px;padding-right:0px;padding-bottom:0px;padding-left:0px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"font-size: 12px; line-height: 1.2; color: #a8bf6f; font-family: Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif; mso-line-height-alt: 14px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t<p style=\"font-size: 12px; line-height: 1.2; text-align: center; word-break: break-word; mso-line-height-alt: 14px; margin: 0;\">Email <span style=\"color: #ffffff; font-size: 12px;\">contact@vissoft.vn</span></p>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]></td></tr></table><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<!--[if (!mso)&(!IE)]><!-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t\t\t<!--<![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]></td></tr></table></td></tr></table><![endif]-->\n" +
                        "\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t<div style=\"background-color:transparent;\">\n" +
                        "\t\t\t\t\t\t<div class=\"block-grid \" style=\"Margin: 0 auto; min-width: 320px; max-width: 600px; overflow-wrap: break-word; word-wrap: break-word; word-break: break-word; background-color: transparent;\">\n" +
                        "\t\t\t\t\t\t\t<div style=\"border-collapse: collapse;display: table;width: 100%;background-color:transparent;\">\n" +
                        "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"background-color:transparent;\"><tr><td align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px\"><tr class=\"layout-full-width\" style=\"background-color:transparent\"><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]><td align=\"center\" width=\"600\" style=\"background-color:transparent;width:600px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top:0px; padding-bottom:5px;\"><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t<div class=\"col num12\" style=\"min-width: 320px; max-width: 600px; display: table-cell; vertical-align: top; width: 600px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t<div style=\"width:100% !important;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t<!--[if (!mso)&(!IE)]><!-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t<div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:0px; padding-bottom:5px; padding-right: 0px; padding-left: 0px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<!--<![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<div class=\"img-container center autowidth\" align=\"center\" style=\"padding-right: 0px;padding-left: 0px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr style=\"line-height:0px\"><td style=\"padding-right: 0px;padding-left: 0px;\" align=\"center\"><![endif]--><img class=\"center autowidth\" align=\"center\" border=\"0\" src=\"https://d1oco4z2z1fhwp.cloudfront.net/templates/default/20/rounder-dwn.png\" alt=\"Image\" title=\"Image\" style=\"text-decoration: none; -ms-interpolation-mode: bicubic; border: 0; height: auto; width: 100%; max-width: 600px; display: block;\" width=\"600\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]></td></tr></table><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<table class=\"divider\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;\" role=\"presentation\" valign=\"top\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t<tbody>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t<tr style=\"vertical-align: top;\" valign=\"top\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"divider_inner\" style=\"word-break: break-word; vertical-align: top; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%; padding-top: 30px; padding-right: 30px; padding-bottom: 30px; padding-left: 30px;\" valign=\"top\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<table class=\"divider_content\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-top: 0px solid transparent; width: 100%;\" align=\"center\" role=\"presentation\" valign=\"top\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tbody>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr style=\"vertical-align: top;\" valign=\"top\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td style=\"word-break: break-word; vertical-align: top; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;\" valign=\"top\"><span></span></td>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tbody>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</table>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t</tbody>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t</table>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<!--[if (!mso)&(!IE)]><!-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t\t\t<!--<![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]></td></tr></table></td></tr></table><![endif]-->\n" +
                        "\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n" +
                        "\t\t\t\t</td>\n" +
                        "\t\t\t</tr>\n" +
                        "\t\t</tbody>\n" +
                        "\t</table>\n" +
                        "\t<!--[if (IE)]></div><![endif]-->\n" +
                        "</body>\n" +
                        "\n" +
                        "</html>";

        return emailContent;
    }

    @Override
    public String emailSendToApprovertimework(
            String username,
            String fullName,
            String dateBegin,
            String dateEnd,
            String reasonName,
            String description,
            String approver,
            String approverName,
            String managerLv2
    ) {

        String emailContent =
                "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional //EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
                        "<html xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:v=\"urn:schemas-microsoft-com:vml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\">\n" +
                        "\n" +
                        "<head>\n" +
                        "\t<!--[if gte mso 9]><xml><o:OfficeDocumentSettings><o:AllowPNG/><o:PixelsPerInch>96</o:PixelsPerInch></o:OfficeDocumentSettings></xml><![endif]-->\n" +
                        "\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\n" +
                        "\t<meta name=\"viewport\" content=\"width=device-width\">\n" +
                        "\t<!--[if !mso]><!-->\n" +
                        "\t<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
                        "\t<!--<![endif]-->\n" +
                        "\t<title></title>\n" +
                        "\t<!--[if !mso]><!-->\n" +
                        "\t<link href=\"https://fonts.googleapis.com/css?family=Montserrat\" rel=\"stylesheet\" type=\"text/css\">\n" +
                        "\t<!--<![endif]-->\n" +
                        "\t<style type=\"text/css\">\n" +
                        "\t\tbody {\n" +
                        "\t\t\tmargin: 0;\n" +
                        "\t\t\tpadding: 0;\n" +
                        "\t\t}\n" +
                        "\n" +
                        "\t\ttable,\n" +
                        "\t\ttd,\n" +
                        "\t\ttr {\n" +
                        "\t\t\tvertical-align: top;\n" +
                        "\t\t\tborder-collapse: collapse;\n" +
                        "\t\t}\n" +
                        "\n" +
                        "\t\t* {\n" +
                        "\t\t\tline-height: inherit;\n" +
                        "\t\t}\n" +
                        "\n" +
                        "\t\ta[x-apple-data-detectors=true] {\n" +
                        "\t\t\tcolor: inherit !important;\n" +
                        "\t\t\ttext-decoration: none !important;\n" +
                        "\t\t}\n" +
                        "\t</style>\n" +
                        "\t<style type=\"text/css\" id=\"media-query\">\n" +
                        "\t\t@media (max-width: 620px) {\n" +
                        "\n" +
                        "\t\t\t.block-grid,\n" +
                        "\t\t\t.col {\n" +
                        "\t\t\t\tmin-width: 320px !important;\n" +
                        "\t\t\t\tmax-width: 100% !important;\n" +
                        "\t\t\t\tdisplay: block !important;\n" +
                        "\t\t\t}\n" +
                        "\n" +
                        "\t\t\t.block-grid {\n" +
                        "\t\t\t\twidth: 100% !important;\n" +
                        "\t\t\t}\n" +
                        "\n" +
                        "\t\t\t.col {\n" +
                        "\t\t\t\twidth: 100% !important;\n" +
                        "\t\t\t}\n" +
                        "\n" +
                        "\t\t\t.col>div {\n" +
                        "\t\t\t\tmargin: 0 auto;\n" +
                        "\t\t\t}\n" +
                        "\n" +
                        "\t\t\timg.fullwidth,\n" +
                        "\t\t\timg.fullwidthOnMobile {\n" +
                        "\t\t\t\tmax-width: 100% !important;\n" +
                        "\t\t\t}\n" +
                        "\n" +
                        "\t\t\t.no-stack .col {\n" +
                        "\t\t\t\tmin-width: 0 !important;\n" +
                        "\t\t\t\tdisplay: table-cell !important;\n" +
                        "\t\t\t}\n" +
                        "\n" +
                        "\t\t\t.no-stack.two-up .col {\n" +
                        "\t\t\t\twidth: 50% !important;\n" +
                        "\t\t\t}\n" +
                        "\n" +
                        "\t\t\t.no-stack .col.num4 {\n" +
                        "\t\t\t\twidth: 33% !important;\n" +
                        "\t\t\t}\n" +
                        "\n" +
                        "\t\t\t.no-stack .col.num8 {\n" +
                        "\t\t\t\twidth: 66% !important;\n" +
                        "\t\t\t}\n" +
                        "\n" +
                        "\t\t\t.no-stack .col.num4 {\n" +
                        "\t\t\t\twidth: 33% !important;\n" +
                        "\t\t\t}\n" +
                        "\n" +
                        "\t\t\t.no-stack .col.num3 {\n" +
                        "\t\t\t\twidth: 25% !important;\n" +
                        "\t\t\t}\n" +
                        "\n" +
                        "\t\t\t.no-stack .col.num6 {\n" +
                        "\t\t\t\twidth: 50% !important;\n" +
                        "\t\t\t}\n" +
                        "\n" +
                        "\t\t\t.no-stack .col.num9 {\n" +
                        "\t\t\t\twidth: 75% !important;\n" +
                        "\t\t\t}\n" +
                        "\n" +
                        "\t\t\t.video-block {\n" +
                        "\t\t\t\tmax-width: none !important;\n" +
                        "\t\t\t}\n" +
                        "\n" +
                        "\t\t\t.mobile_hide {\n" +
                        "\t\t\t\tmin-height: 0px;\n" +
                        "\t\t\t\tmax-height: 0px;\n" +
                        "\t\t\t\tmax-width: 0px;\n" +
                        "\t\t\t\tdisplay: none;\n" +
                        "\t\t\t\toverflow: hidden;\n" +
                        "\t\t\t\tfont-size: 0px;\n" +
                        "\t\t\t}\n" +
                        "\n" +
                        "\t\t\t.desktop_hide {\n" +
                        "\t\t\t\tdisplay: block !important;\n" +
                        "\t\t\t\tmax-height: none !important;\n" +
                        "\t\t\t}\n" +
                        "\t\t}\n" +
                        "\t</style>\n" +
                        "</head>\n" +
                        "\n" +
                        "<body class=\"clean-body\" style=\"margin: 0; padding: 0; -webkit-text-size-adjust: 100%; background-color: #e2eace;\">\n" +
                        "\t<!--[if IE]><div class=\"ie-browser\"><![endif]-->\n" +
                        "\t<table class=\"nl-container\" style=\"table-layout: fixed; vertical-align: top; min-width: 320px; Margin: 0 auto; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #e2eace; width: 100%;\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" width=\"100%\" bgcolor=\"#e2eace\" valign=\"top\">\n" +
                        "\t\t<tbody>\n" +
                        "\t\t\t<tr style=\"vertical-align: top;\" valign=\"top\">\n" +
                        "\t\t\t\t<td style=\"word-break: break-word; vertical-align: top;\" valign=\"top\">\n" +
                        "\t\t\t\t\t<!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td align=\"center\" style=\"background-color:#e2eace\"><![endif]-->\n" +
                        "\t\t\t\t\t<div style=\"background-color:transparent;\">\n" +
                        "\t\t\t\t\t\t<div class=\"block-grid \" style=\"Margin: 0 auto; min-width: 320px; max-width: 600px; overflow-wrap: break-word; word-wrap: break-word; word-break: break-word; background-color: transparent;\">\n" +
                        "\t\t\t\t\t\t\t<div style=\"border-collapse: collapse;display: table;width: 100%;background-color:transparent;\">\n" +
                        "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"background-color:transparent;\"><tr><td align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px\"><tr class=\"layout-full-width\" style=\"background-color:transparent\"><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]><td align=\"center\" width=\"600\" style=\"background-color:transparent;width:600px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top:5px; padding-bottom:0px;\"><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t<div class=\"col num12\" style=\"min-width: 320px; max-width: 600px; display: table-cell; vertical-align: top; width: 600px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t<div style=\"width:100% !important;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t<!--[if (!mso)&(!IE)]><!-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t<div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:5px; padding-bottom:0px; padding-right: 0px; padding-left: 0px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<!--<![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<div class=\"img-container center autowidth\" align=\"center\" style=\"padding-right: 0px;padding-left: 0px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr style=\"line-height:0px\"><td style=\"padding-right: 0px;padding-left: 0px;\" align=\"center\"><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"font-size:1px;line-height:25px\">&nbsp;</div><img class=\"center autowidth\" align=\"center\" border=\"0\" src=\"https://d1oco4z2z1fhwp.cloudfront.net/templates/default/20/rounder-up.png\" alt=\"Image\" title=\"Image\" style=\"text-decoration: none; -ms-interpolation-mode: bicubic; border: 0; height: auto; width: 100%; max-width: 600px; display: block;\" width=\"600\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]></td></tr></table><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<!--[if (!mso)&(!IE)]><!-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t\t\t<!--<![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]></td></tr></table></td></tr></table><![endif]-->\n" +
                        "\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t<div style=\"background-color:transparent;\">\n" +
                        "\t\t\t\t\t\t<div class=\"block-grid \" style=\"Margin: 0 auto; min-width: 320px; max-width: 600px; overflow-wrap: break-word; word-wrap: break-word; word-break: break-word; background-color: #FFFFFF;\">\n" +
                        "\t\t\t\t\t\t\t<div style=\"border-collapse: collapse;display: table;width: 100%;background-color:#FFFFFF;\">\n" +
                        "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"background-color:transparent;\"><tr><td align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px\"><tr class=\"layout-full-width\" style=\"background-color:#FFFFFF\"><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]><td align=\"center\" width=\"600\" style=\"background-color:#FFFFFF;width:600px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top:5px; padding-bottom:5px;\"><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t<div class=\"col num12\" style=\"min-width: 320px; max-width: 600px; display: table-cell; vertical-align: top; width: 600px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t<div style=\"width:100% !important;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t<!--[if (!mso)&(!IE)]><!-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t<div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:5px; padding-bottom:5px; padding-right: 0px; padding-left: 0px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<!--<![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<div class=\"img-container center\" align=\"center\" style=\"padding-right: 0px;padding-left: 0px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr style=\"line-height:0px\"><td style=\"padding-right: 0px;padding-left: 0px;\" align=\"center\"><![endif]--><img class=\"center\" align=\"center\" border=\"0\" src=\"https://media.licdn.com/dms/image/C561BAQFvBoDlloIR4w/company-background_10000/0?e=2159024400&amp;v=beta&amp;t=vmTY91FoP8rQRgvgePKIao5DgLbbV3pGjlLfFwHIwwM\" alt=\"Image\" title=\"Image\" style=\"text-decoration: none; -ms-interpolation-mode: bicubic; border: 0; height: auto; width: 100%; max-width: 360px; display: block;\" width=\"360\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]></td></tr></table><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 10px; padding-left: 10px; padding-top: 10px; padding-bottom: 10px; font-family: Tahoma, sans-serif\"><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<div style=\"color:#555555;font-family:Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif;line-height:1.5;padding-top:10px;padding-right:10px;padding-bottom:10px;padding-left:10px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"font-size: 12px; line-height: 1.5; color: #555555; font-family: Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif; mso-line-height-alt: 18px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t<p style=\"font-size: 14px; line-height: 1.5; text-align: center; word-break: break-word; mso-line-height-alt: 21px; margin: 0;\">Công Ty Cổ Phần Công Nghệ Và Truyền Thông VIS</p>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]></td></tr></table><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<!--[if (!mso)&(!IE)]><!-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t\t\t<!--<![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]></td></tr></table></td></tr></table><![endif]-->\n" +
                        "\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t<div style=\"background-color:transparent;\">\n" +
                        "\t\t\t\t\t\t<div class=\"block-grid \" style=\"Margin: 0 auto; min-width: 320px; max-width: 600px; overflow-wrap: break-word; word-wrap: break-word; word-break: break-word; background-color: #FFFFFF;\">\n" +
                        "\t\t\t\t\t\t\t<div style=\"border-collapse: collapse;display: table;width: 100%;background-color:#FFFFFF;\">\n" +
                        "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"background-color:transparent;\"><tr><td align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px\"><tr class=\"layout-full-width\" style=\"background-color:#FFFFFF\"><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]><td align=\"center\" width=\"600\" style=\"background-color:#FFFFFF;width:600px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top:0px; padding-bottom:5px;\"><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t<div class=\"col num12\" style=\"min-width: 320px; max-width: 600px; display: table-cell; vertical-align: top; width: 600px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t<div style=\"width:100% !important;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t<!--[if (!mso)&(!IE)]><!-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t<div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:0px; padding-bottom:5px; padding-right: 0px; padding-left: 0px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<!--<![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 10px; padding-left: 10px; padding-top: 10px; padding-bottom: 10px; font-family: Tahoma, sans-serif\"><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<div style=\"color:#0D0D0D;font-family:Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif;line-height:1.2;padding-top:10px;padding-right:10px;padding-bottom:10px;padding-left:10px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"font-size: 12px; line-height: 1.2; color: #0D0D0D; font-family: Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif; mso-line-height-alt: 14px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t<p style=\"font-size: 28px; line-height: 1.2; text-align: center; word-break: break-word; mso-line-height-alt: 34px; margin: 0;\"><span style=\"font-size: 28px;\"><strong>Thông báo Đăng kí giờ làm</strong></span></p>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]></td></tr></table><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<div class=\"img-container center\" align=\"center\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr style=\"line-height:0px\"><td style=\"\" align=\"center\"><![endif]--><img class=\"center\" align=\"center\" border=\"0\" src=\"https://d1oco4z2z1fhwp.cloudfront.net/templates/default/20/divider.png\" alt=\"Image\" title=\"Image\" style=\"text-decoration: none; -ms-interpolation-mode: bicubic; border: 0; height: auto; width: 100%; max-width: 318px; display: block;\" width=\"318\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]></td></tr></table><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 10px; padding-left: 10px; padding-top: 10px; padding-bottom: 10px; font-family: Tahoma, sans-serif\"><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<div style=\"color:#555555;font-family:Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif;line-height:1.5;padding-top:10px;padding-right:10px;padding-bottom:10px;padding-left:10px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"font-size: 12px; line-height: 1.5; color: #555555; font-family: Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif; mso-line-height-alt: 18px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t<p style=\"font-size: 14px; line-height: 1.5; text-align: center; word-break: break-word; mso-line-height-alt: 21px; margin: 0;\"><span style=\"color: #a8bf6f; font-size: 14px;\"><strong>Chào anh/chị!</strong></span></p>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t<p style=\"font-size: 14px; line-height: 1.5; text-align: center; word-break: break-word; mso-line-height-alt: 21px; margin: 0;\"><span style=\"color: #a8bf6f; font-size: 14px;\"><strong>Có một đơn đăng kí giờ làm được gửi cho anh chị.</strong></span></p>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]></td></tr></table><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 10px; padding-left: 10px; padding-top: 20px; padding-bottom: 10px; font-family: Tahoma, sans-serif\"><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<div style=\"color:#0D0D0D;font-family:Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif;line-height:1.5;padding-top:20px;padding-right:10px;padding-bottom:10px;padding-left:10px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"line-height: 1.5; font-size: 12px; color: #0D0D0D; font-family: Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif; mso-line-height-alt: 18px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t<p style=\"line-height: 1.5; word-break: break-word; font-size: 14px; mso-line-height-alt: 21px; margin: 0;\"><span style=\"font-size: 14px;\">Thông tin chi tiết:</span></p>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t<p style=\"line-height: 1.5; word-break: break-word; font-size: 14px; mso-line-height-alt: 21px; margin: 0;\"><span style=\"font-size: 14px;\">Người gửi:<strong> "+ username +" (" +fullName+")" + "&nbsp;</strong></span></p>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t<p style=\"line-height: 1.5; word-break: break-word; font-size: 14px; mso-line-height-alt: 21px; margin: 0;\"><span style=\"font-size: 14px;\">Người duyệt:<strong> "+ approver +" (" + approverName +")"+ "&nbsp;</strong></span></p>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t<p style=\"line-height: 1.5; word-break: break-word; font-size: 14px; mso-line-height-alt: 21px; margin: 0;\"><span style=\"font-size: 14px;\">Quản lí trên một cấp:<strong> "+ managerLv2 + "&nbsp;</strong></span></p>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t<p style=\"line-height: 1.5; word-break: break-word; font-size: 14px; mso-line-height-alt: 21px; margin: 0;\"><span style=\"font-size: 14px;\"> "+ reasonName +" với lý do: <strong>"+ description +"</strong></span></p>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t<p style=\"line-height: 1.5; word-break: break-word; font-size: 14px; mso-line-height-alt: 21px; margin: 0;\"><span style=\"font-size: 14px;\">Ngày bắt đầu nghỉ:<strong> "+dateBegin+"</strong></span></p>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t<p style=\"line-height: 1.5; word-break: break-word; font-size: 14px; mso-line-height-alt: 21px; margin: 0;\"><span style=\"font-size: 14px;\">Ngày kết thúc nghỉ:<strong> "+dateEnd+"</strong></span></p>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]></td></tr></table><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<div class=\"button-container\" align=\"center\" style=\"padding-top:25px;padding-right:10px;padding-bottom:10px;padding-left:10px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"border-spacing: 0; border-collapse: collapse; mso-table-lspace:0pt; mso-table-rspace:0pt;\"><tr><td style=\"padding-top: 25px; padding-right: 10px; padding-bottom: 10px; padding-left: 10px\" align=\"center\"><v:roundrect xmlns:v=\"urn:schemas-microsoft-com:vml\" xmlns:w=\"urn:schemas-microsoft-com:office:word\" href=\"http://14.225.5.246:8864/#/timeoff-management\" style=\"height:46.5pt; width:100.5pt; v-text-anchor:middle;\" arcsize=\"7%\" stroke=\"false\" fillcolor=\"#a8bf6f\"><w:anchorlock/><v:textbox inset=\"0,0,0,0\"><center style=\"color:#ffffff; font-family:Tahoma, sans-serif; font-size:16px\"><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t<a href=\"http://14.225.5.246:8864/#/timeoff-management\" target=\"_blank\" style=\"-webkit-text-size-adjust: none; text-decoration: none; display: inline-block; color: #ffffff; background-color: #a8bf6f; border-radius: 4px; -webkit-border-radius: 4px; -moz-border-radius: 4px; width: auto; width: auto; border-top: 1px solid #a8bf6f; border-right: 1px solid #a8bf6f; border-bottom: 1px solid #a8bf6f; border-left: 1px solid #a8bf6f; padding-top: 15px; padding-bottom: 15px; font-family: Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif; text-align: center; mso-border-alt: none; word-break: keep-all;\"><span style=\"padding-left:15px;padding-right:15px;font-size:16px;display:inline-block;\"><span style=\"font-size: 16px; line-height: 2; word-break: break-word; mso-line-height-alt: 32px;\">Duyệt đơn đăng kí</span></span></a>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]></center></v:textbox></v:roundrect></td></tr></table><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<table class=\"divider\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;\" role=\"presentation\" valign=\"top\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t<tbody>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t<tr style=\"vertical-align: top;\" valign=\"top\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"divider_inner\" style=\"word-break: break-word; vertical-align: top; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%; padding-top: 30px; padding-right: 10px; padding-bottom: 10px; padding-left: 10px;\" valign=\"top\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<table class=\"divider_content\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-top: 0px solid transparent; width: 100%;\" align=\"center\" role=\"presentation\" valign=\"top\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tbody>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr style=\"vertical-align: top;\" valign=\"top\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td style=\"word-break: break-word; vertical-align: top; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;\" valign=\"top\"><span></span></td>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tbody>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</table>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t</tbody>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t</table>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<!--[if (!mso)&(!IE)]><!-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t\t\t<!--<![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]></td></tr></table></td></tr></table><![endif]-->\n" +
                        "\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t<div style=\"background-color:transparent;\">\n" +
                        "\t\t\t\t\t\t<div class=\"block-grid three-up\" style=\"Margin: 0 auto; min-width: 320px; max-width: 600px; overflow-wrap: break-word; word-wrap: break-word; word-break: break-word; background-color: #525252;\">\n" +
                        "\t\t\t\t\t\t\t<div style=\"border-collapse: collapse;display: table;width: 100%;background-color:#525252;\">\n" +
                        "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"background-color:transparent;\"><tr><td align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px\"><tr class=\"layout-full-width\" style=\"background-color:#525252\"><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]><td align=\"center\" width=\"200\" style=\"background-color:#525252;width:200px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top:0px; padding-bottom:0px;\"><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t<div class=\"col num4\" style=\"max-width: 320px; min-width: 200px; display: table-cell; vertical-align: top; width: 200px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t<div style=\"width:100% !important;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t<!--[if (!mso)&(!IE)]><!-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t<div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:0px; padding-bottom:0px; padding-right: 0px; padding-left: 0px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<!--<![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<table class=\"social_icons\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" role=\"presentation\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" valign=\"top\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t<tbody>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t<tr style=\"vertical-align: top;\" valign=\"top\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td style=\"word-break: break-word; vertical-align: top; padding-top: 15px; padding-right: 0px; padding-bottom: 0px; padding-left: 0px;\" valign=\"top\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<table class=\"social_table\" align=\"center\" to=\"to\" activate=\"activate\" alignment=\"alignment\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: undefined; mso-table-tspace: 0; mso-table-rspace: 0; mso-table-bspace: 0; mso-table-lspace: 0;\" valign=\"top\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tbody>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr style=\"vertical-align: top; display: inline-block; text-align: center;\" align=\"center\" valign=\"top\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td style=\"word-break: break-word; vertical-align: top; padding-bottom: 5px; padding-right: 3px; padding-left: 3px;\" valign=\"top\"><a href=\"http://vissoft.vn\" target=\"_blank\"><img width=\"32\" height=\"32\" src=\"https://d2fi4ri5dhpqd1.cloudfront.net/public/resources/social-networks-icon-sets/t-only-logo-default-gray/facebook@2x.png\" alt=\"Facebook\" title=\"Facebook\" style=\"text-decoration: none; -ms-interpolation-mode: bicubic; height: auto; border: none; display: block;\"></a></td>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td style=\"word-break: break-word; vertical-align: top; padding-bottom: 5px; padding-right: 3px; padding-left: 3px;\" valign=\"top\"><a href=\"http://vissoft.vn\" target=\"_blank\"><img width=\"32\" height=\"32\" src=\"https://d2fi4ri5dhpqd1.cloudfront.net/public/resources/social-networks-icon-sets/t-only-logo-default-gray/twitter@2x.png\" alt=\"Twitter\" title=\"Twitter\" style=\"text-decoration: none; -ms-interpolation-mode: bicubic; height: auto; border: none; display: block;\"></a></td>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td style=\"word-break: break-word; vertical-align: top; padding-bottom: 5px; padding-right: 3px; padding-left: 3px;\" valign=\"top\"><a href=\"http://vissoft.vn\" target=\"_blank\"><img width=\"32\" height=\"32\" src=\"https://d2fi4ri5dhpqd1.cloudfront.net/public/resources/social-networks-icon-sets/t-only-logo-default-gray/googleplus@2x.png\" alt=\"Google+\" title=\"Google+\" style=\"text-decoration: none; -ms-interpolation-mode: bicubic; height: auto; border: none; display: block;\"></a></td>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tbody>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</table>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t</tbody>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t</table>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<!--[if (!mso)&(!IE)]><!-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t\t\t<!--<![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]></td><td align=\"center\" width=\"200\" style=\"background-color:#525252;width:200px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top:5px; padding-bottom:5px;\"><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t<div class=\"col num4\" style=\"max-width: 320px; min-width: 200px; display: table-cell; vertical-align: top; width: 200px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t<div style=\"width:100% !important;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t<!--[if (!mso)&(!IE)]><!-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t<div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:5px; padding-bottom:5px; padding-right: 0px; padding-left: 0px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<!--<![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top: 20px; padding-bottom: 0px; font-family: Tahoma, sans-serif\"><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<div style=\"color:#a8bf6f;font-family:Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif;line-height:1.2;padding-top:20px;padding-right:0px;padding-bottom:0px;padding-left:0px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"font-size: 12px; line-height: 1.2; color: #a8bf6f; font-family: Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif; mso-line-height-alt: 14px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t<p style=\"font-size: 12px; line-height: 1.2; text-align: center; word-break: break-word; mso-line-height-alt: 14px; margin: 0;\"><span style=\"color: #ffffff; font-size: 12px;\"><span style=\"font-size: 12px; color: #a8bf6f;\">Tel.:</span> +(024) - 666 20346</span></p>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]></td></tr></table><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<!--[if (!mso)&(!IE)]><!-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t\t\t<!--<![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]></td><td align=\"center\" width=\"200\" style=\"background-color:#525252;width:200px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top:5px; padding-bottom:5px;\"><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t<div class=\"col num4\" style=\"max-width: 320px; min-width: 200px; display: table-cell; vertical-align: top; width: 200px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t<div style=\"width:100% !important;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t<!--[if (!mso)&(!IE)]><!-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t<div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:5px; padding-bottom:5px; padding-right: 0px; padding-left: 0px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<!--<![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top: 20px; padding-bottom: 0px; font-family: Tahoma, sans-serif\"><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<div style=\"color:#a8bf6f;font-family:Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif;line-height:1.2;padding-top:20px;padding-right:0px;padding-bottom:0px;padding-left:0px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"font-size: 12px; line-height: 1.2; color: #a8bf6f; font-family: Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif; mso-line-height-alt: 14px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t<p style=\"font-size: 12px; line-height: 1.2; text-align: center; word-break: break-word; mso-line-height-alt: 14px; margin: 0;\">Email <span style=\"color: #ffffff; font-size: 12px;\">contact@vissoft.vn</span></p>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]></td></tr></table><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<!--[if (!mso)&(!IE)]><!-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t\t\t<!--<![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]></td></tr></table></td></tr></table><![endif]-->\n" +
                        "\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t<div style=\"background-color:transparent;\">\n" +
                        "\t\t\t\t\t\t<div class=\"block-grid \" style=\"Margin: 0 auto; min-width: 320px; max-width: 600px; overflow-wrap: break-word; word-wrap: break-word; word-break: break-word; background-color: transparent;\">\n" +
                        "\t\t\t\t\t\t\t<div style=\"border-collapse: collapse;display: table;width: 100%;background-color:transparent;\">\n" +
                        "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"background-color:transparent;\"><tr><td align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px\"><tr class=\"layout-full-width\" style=\"background-color:transparent\"><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]><td align=\"center\" width=\"600\" style=\"background-color:transparent;width:600px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top:0px; padding-bottom:5px;\"><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t<div class=\"col num12\" style=\"min-width: 320px; max-width: 600px; display: table-cell; vertical-align: top; width: 600px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t<div style=\"width:100% !important;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t<!--[if (!mso)&(!IE)]><!-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t<div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:0px; padding-bottom:5px; padding-right: 0px; padding-left: 0px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<!--<![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<div class=\"img-container center autowidth\" align=\"center\" style=\"padding-right: 0px;padding-left: 0px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr style=\"line-height:0px\"><td style=\"padding-right: 0px;padding-left: 0px;\" align=\"center\"><![endif]--><img class=\"center autowidth\" align=\"center\" border=\"0\" src=\"https://d1oco4z2z1fhwp.cloudfront.net/templates/default/20/rounder-dwn.png\" alt=\"Image\" title=\"Image\" style=\"text-decoration: none; -ms-interpolation-mode: bicubic; border: 0; height: auto; width: 100%; max-width: 600px; display: block;\" width=\"600\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]></td></tr></table><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<table class=\"divider\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;\" role=\"presentation\" valign=\"top\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t<tbody>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t<tr style=\"vertical-align: top;\" valign=\"top\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"divider_inner\" style=\"word-break: break-word; vertical-align: top; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%; padding-top: 30px; padding-right: 30px; padding-bottom: 30px; padding-left: 30px;\" valign=\"top\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<table class=\"divider_content\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-top: 0px solid transparent; width: 100%;\" align=\"center\" role=\"presentation\" valign=\"top\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tbody>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr style=\"vertical-align: top;\" valign=\"top\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td style=\"word-break: break-word; vertical-align: top; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;\" valign=\"top\"><span></span></td>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tbody>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</table>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t</tbody>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t</table>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<!--[if (!mso)&(!IE)]><!-->\n" +
                        "\t\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t\t\t<!--<![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n" +
                        "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]></td></tr></table></td></tr></table><![endif]-->\n" +
                        "\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n" +
                        "\t\t\t\t</td>\n" +
                        "\t\t\t</tr>\n" +
                        "\t\t</tbody>\n" +
                        "\t</table>\n" +
                        "\t<!--[if (IE)]></div><![endif]-->\n" +
                        "</body>\n" +
                        "\n" +
                        "</html>";
        return emailContent;


    }

    @Override
    public String emailSendToUserTimeWork(String sender,
                                          String approver,
                                          String receiver,
                                          String managerLv2,
                                          String reason,
                                          String approverDate,
                                          String dateBegin,
                                          String dateEnd,
                                          Integer status,
                                          String description,
                                          String reasonReject) {

        String cssStatus;
        String contentStatus;

        if (status == 1) {
            cssStatus = "style =\"color:green;\" ";
            contentStatus = "Đồng ý";

            String emailContentApproved =
                    "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional //EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
                            "<html xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:v=\"urn:schemas-microsoft-com:vml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\">\n" +
                            "\n" +
                            "<head>\n" +
                            "\t<!--[if gte mso 9]><xml><o:OfficeDocumentSettings><o:AllowPNG/><o:PixelsPerInch>96</o:PixelsPerInch></o:OfficeDocumentSettings></xml><![endif]-->\n" +
                            "\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\n" +
                            "\t<meta name=\"viewport\" content=\"width=device-width\">\n" +
                            "\t<!--[if !mso]><!-->\n" +
                            "\t<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
                            "\t<!--<![endif]-->\n" +
                            "\t<title></title>\n" +
                            "\t<!--[if !mso]><!-->\n" +
                            "\t<link href=\"https://fonts.googleapis.com/css?family=Montserrat\" rel=\"stylesheet\" type=\"text/css\">\n" +
                            "\t<!--<![endif]-->\n" +
                            "\t<style type=\"text/css\">\n" +
                            "\t\tbody {\n" +
                            "\t\t\tmargin: 0;\n" +
                            "\t\t\tpadding: 0;\n" +
                            "\t\t}\n" +
                            "\n" +
                            "\t\ttable,\n" +
                            "\t\ttd,\n" +
                            "\t\ttr {\n" +
                            "\t\t\tvertical-align: top;\n" +
                            "\t\t\tborder-collapse: collapse;\n" +
                            "\t\t}\n" +
                            "\n" +
                            "\t\t* {\n" +
                            "\t\t\tline-height: inherit;\n" +
                            "\t\t}\n" +
                            "\n" +
                            "\t\ta[x-apple-data-detectors=true] {\n" +
                            "\t\t\tcolor: inherit !important;\n" +
                            "\t\t\ttext-decoration: none !important;\n" +
                            "\t\t}\n" +
                            "\t</style>\n" +
                            "\t<style type=\"text/css\" id=\"media-query\">\n" +
                            "\t\t@media (max-width: 620px) {\n" +
                            "\n" +
                            "\t\t\t.block-grid,\n" +
                            "\t\t\t.col {\n" +
                            "\t\t\t\tmin-width: 320px !important;\n" +
                            "\t\t\t\tmax-width: 100% !important;\n" +
                            "\t\t\t\tdisplay: block !important;\n" +
                            "\t\t\t}\n" +
                            "\n" +
                            "\t\t\t.block-grid {\n" +
                            "\t\t\t\twidth: 100% !important;\n" +
                            "\t\t\t}\n" +
                            "\n" +
                            "\t\t\t.col {\n" +
                            "\t\t\t\twidth: 100% !important;\n" +
                            "\t\t\t}\n" +
                            "\n" +
                            "\t\t\t.col>div {\n" +
                            "\t\t\t\tmargin: 0 auto;\n" +
                            "\t\t\t}\n" +
                            "\n" +
                            "\t\t\timg.fullwidth,\n" +
                            "\t\t\timg.fullwidthOnMobile {\n" +
                            "\t\t\t\tmax-width: 100% !important;\n" +
                            "\t\t\t}\n" +
                            "\n" +
                            "\t\t\t.no-stack .col {\n" +
                            "\t\t\t\tmin-width: 0 !important;\n" +
                            "\t\t\t\tdisplay: table-cell !important;\n" +
                            "\t\t\t}\n" +
                            "\n" +
                            "\t\t\t.no-stack.two-up .col {\n" +
                            "\t\t\t\twidth: 50% !important;\n" +
                            "\t\t\t}\n" +
                            "\n" +
                            "\t\t\t.no-stack .col.num4 {\n" +
                            "\t\t\t\twidth: 33% !important;\n" +
                            "\t\t\t}\n" +
                            "\n" +
                            "\t\t\t.no-stack .col.num8 {\n" +
                            "\t\t\t\twidth: 66% !important;\n" +
                            "\t\t\t}\n" +
                            "\n" +
                            "\t\t\t.no-stack .col.num4 {\n" +
                            "\t\t\t\twidth: 33% !important;\n" +
                            "\t\t\t}\n" +
                            "\n" +
                            "\t\t\t.no-stack .col.num3 {\n" +
                            "\t\t\t\twidth: 25% !important;\n" +
                            "\t\t\t}\n" +
                            "\n" +
                            "\t\t\t.no-stack .col.num6 {\n" +
                            "\t\t\t\twidth: 50% !important;\n" +
                            "\t\t\t}\n" +
                            "\n" +
                            "\t\t\t.no-stack .col.num9 {\n" +
                            "\t\t\t\twidth: 75% !important;\n" +
                            "\t\t\t}\n" +
                            "\n" +
                            "\t\t\t.video-block {\n" +
                            "\t\t\t\tmax-width: none !important;\n" +
                            "\t\t\t}\n" +
                            "\n" +
                            "\t\t\t.mobile_hide {\n" +
                            "\t\t\t\tmin-height: 0px;\n" +
                            "\t\t\t\tmax-height: 0px;\n" +
                            "\t\t\t\tmax-width: 0px;\n" +
                            "\t\t\t\tdisplay: none;\n" +
                            "\t\t\t\toverflow: hidden;\n" +
                            "\t\t\t\tfont-size: 0px;\n" +
                            "\t\t\t}\n" +
                            "\n" +
                            "\t\t\t.desktop_hide {\n" +
                            "\t\t\t\tdisplay: block !important;\n" +
                            "\t\t\t\tmax-height: none !important;\n" +
                            "\t\t\t}\n" +
                            "\t\t}\n" +
                            "\t</style>\n" +
                            "</head>\n" +
                            "\n" +
                            "<body class=\"clean-body\" style=\"margin: 0; padding: 0; -webkit-text-size-adjust: 100%; background-color: #e2eace;\">\n" +
                            "\t<!--[if IE]><div class=\"ie-browser\"><![endif]-->\n" +
                            "\t<table class=\"nl-container\" style=\"table-layout: fixed; vertical-align: top; min-width: 320px; Margin: 0 auto; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #e2eace; width: 100%;\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" width=\"100%\" bgcolor=\"#e2eace\" valign=\"top\">\n" +
                            "\t\t<tbody>\n" +
                            "\t\t\t<tr style=\"vertical-align: top;\" valign=\"top\">\n" +
                            "\t\t\t\t<td style=\"word-break: break-word; vertical-align: top;\" valign=\"top\">\n" +
                            "\t\t\t\t\t<!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td align=\"center\" style=\"background-color:#e2eace\"><![endif]-->\n" +
                            "\t\t\t\t\t<div style=\"background-color:transparent;\">\n" +
                            "\t\t\t\t\t\t<div class=\"block-grid \" style=\"Margin: 0 auto; min-width: 320px; max-width: 600px; overflow-wrap: break-word; word-wrap: break-word; word-break: break-word; background-color: transparent;\">\n" +
                            "\t\t\t\t\t\t\t<div style=\"border-collapse: collapse;display: table;width: 100%;background-color:transparent;\">\n" +
                            "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"background-color:transparent;\"><tr><td align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px\"><tr class=\"layout-full-width\" style=\"background-color:transparent\"><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]><td align=\"center\" width=\"600\" style=\"background-color:transparent;width:600px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top:5px; padding-bottom:0px;\"><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t<div class=\"col num12\" style=\"min-width: 320px; max-width: 600px; display: table-cell; vertical-align: top; width: 600px;\">\n" +
                            "\t\t\t\t\t\t\t\t\t<div style=\"width:100% !important;\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t<!--[if (!mso)&(!IE)]><!-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t<div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:5px; padding-bottom:0px; padding-right: 0px; padding-left: 0px;\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<!--<![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<div class=\"img-container center autowidth\" align=\"center\" style=\"padding-right: 0px;padding-left: 0px;\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr style=\"line-height:0px\"><td style=\"padding-right: 0px;padding-left: 0px;\" align=\"center\"><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"font-size:1px;line-height:25px\">&nbsp;</div><img class=\"center autowidth\" align=\"center\" border=\"0\" src=\"https://d1oco4z2z1fhwp.cloudfront.net/templates/default/20/rounder-up.png\" alt=\"Image\" title=\"Image\" style=\"text-decoration: none; -ms-interpolation-mode: bicubic; border: 0; height: auto; width: 100%; max-width: 600px; display: block;\" width=\"600\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]></td></tr></table><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<!--[if (!mso)&(!IE)]><!-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t\t\t<!--<![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]></td></tr></table></td></tr></table><![endif]-->\n" +
                            "\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t<div style=\"background-color:transparent;\">\n" +
                            "\t\t\t\t\t\t<div class=\"block-grid \" style=\"Margin: 0 auto; min-width: 320px; max-width: 600px; overflow-wrap: break-word; word-wrap: break-word; word-break: break-word; background-color: #FFFFFF;\">\n" +
                            "\t\t\t\t\t\t\t<div style=\"border-collapse: collapse;display: table;width: 100%;background-color:#FFFFFF;\">\n" +
                            "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"background-color:transparent;\"><tr><td align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px\"><tr class=\"layout-full-width\" style=\"background-color:#FFFFFF\"><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]><td align=\"center\" width=\"600\" style=\"background-color:#FFFFFF;width:600px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top:5px; padding-bottom:5px;\"><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t<div class=\"col num12\" style=\"min-width: 320px; max-width: 600px; display: table-cell; vertical-align: top; width: 600px;\">\n" +
                            "\t\t\t\t\t\t\t\t\t<div style=\"width:100% !important;\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t<!--[if (!mso)&(!IE)]><!-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t<div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:5px; padding-bottom:5px; padding-right: 0px; padding-left: 0px;\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<!--<![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<div class=\"img-container center\" align=\"center\" style=\"padding-right: 0px;padding-left: 0px;\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr style=\"line-height:0px\"><td style=\"padding-right: 0px;padding-left: 0px;\" align=\"center\"><![endif]--><img class=\"center\" align=\"center\" border=\"0\" src=\"https://cdn.itviec.com/employers/vis-soft/logo/social/DXErnqbxaE5NmyzrCp8EBBYG/vis-soft-logo.png\" alt=\"Image\" title=\"Image\" style=\"text-decoration: none; -ms-interpolation-mode: bicubic; border: 0; height: auto; width: 100%; max-width: 150px; display: block;\" width=\"150\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]></td></tr></table><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 10px; padding-left: 10px; padding-top: 10px; padding-bottom: 10px; font-family: Tahoma, sans-serif\"><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<div style=\"color:#555555;font-family:Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif;line-height:1.5;padding-top:10px;padding-right:10px;padding-bottom:10px;padding-left:10px;\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"font-size: 12px; line-height: 1.5; color: #555555; font-family: Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif; mso-line-height-alt: 18px;\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t<p style=\"font-size: 14px; line-height: 1.5; text-align: center; word-break: break-word; mso-line-height-alt: 21px; margin: 0;\">Công ty Cổ Phần Công Nghệ Và Truyền Thông VIS</p>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]></td></tr></table><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<!--[if (!mso)&(!IE)]><!-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t\t\t<!--<![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]></td></tr></table></td></tr></table><![endif]-->\n" +
                            "\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t<div style=\"background-color:transparent;\">\n" +
                            "\t\t\t\t\t\t<div class=\"block-grid \" style=\"Margin: 0 auto; min-width: 320px; max-width: 600px; overflow-wrap: break-word; word-wrap: break-word; word-break: break-word; background-color: #FFFFFF;\">\n" +
                            "\t\t\t\t\t\t\t<div style=\"border-collapse: collapse;display: table;width: 100%;background-color:#FFFFFF;\">\n" +
                            "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"background-color:transparent;\"><tr><td align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px\"><tr class=\"layout-full-width\" style=\"background-color:#FFFFFF\"><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]><td align=\"center\" width=\"600\" style=\"background-color:#FFFFFF;width:600px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top:0px; padding-bottom:5px;\"><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t<div class=\"col num12\" style=\"min-width: 320px; max-width: 600px; display: table-cell; vertical-align: top; width: 600px;\">\n" +
                            "\t\t\t\t\t\t\t\t\t<div style=\"width:100% !important;\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t<!--[if (!mso)&(!IE)]><!-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t<div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:0px; padding-bottom:5px; padding-right: 0px; padding-left: 0px;\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<!--<![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 10px; padding-left: 10px; padding-top: 10px; padding-bottom: 10px; font-family: Tahoma, sans-serif\"><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<div style=\"color:#0D0D0D;font-family:Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif;line-height:1.2;padding-top:10px;padding-right:10px;padding-bottom:10px;padding-left:10px;\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"font-size: 12px; line-height: 1.2; color: #0D0D0D; font-family: Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif; mso-line-height-alt: 14px;\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t<p style=\"font-size: 28px; line-height: 1.2; text-align: center; word-break: break-word; mso-line-height-alt: 34px; margin: 0;\"><span style=\"font-size: 28px;\"><strong>Thông báo nghỉ phép</strong></span></p>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]></td></tr></table><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<div class=\"img-container center\" align=\"center\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr style=\"line-height:0px\"><td style=\"\" align=\"center\"><![endif]--><img class=\"center\" align=\"center\" border=\"0\" src=\"https://d1oco4z2z1fhwp.cloudfront.net/templates/default/20/divider.png\" alt=\"Image\" title=\"Image\" style=\"text-decoration: none; -ms-interpolation-mode: bicubic; border: 0; height: auto; width: 100%; max-width: 318px; display: block;\" width=\"318\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]></td></tr></table><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 10px; padding-left: 10px; padding-top: 10px; padding-bottom: 10px; font-family: Tahoma, sans-serif\"><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<div style=\"color:#555555;font-family:Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif;line-height:1.5;padding-top:10px;padding-right:10px;padding-bottom:10px;padding-left:10px;\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"font-size: 12px; line-height: 1.5; color: #555555; font-family: Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif; mso-line-height-alt: 18px;\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t<p style=\"font-size: 14px; line-height: 1.5; text-align: center; word-break: break-word; mso-line-height-alt: 21px; margin: 0;\"><span style=\"color: #a8bf6f; font-size: 14px;\"><strong>Đơn xin đăng kí giờ làm của " +sender+ " đã được "+approver+" duyệt</strong></span></p>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]></td></tr></table><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 10px; padding-left: 10px; padding-top: 20px; padding-bottom: 10px; font-family: Tahoma, sans-serif\"><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<div style=\"color:#0D0D0D;font-family:Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif;line-height:1.5;padding-top:20px;padding-right:10px;padding-bottom:10px;padding-left:10px;\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"line-height: 1.5; font-size: 12px; color: #0D0D0D; font-family: Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif; mso-line-height-alt: 18px;\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t<p style=\"line-height: 1.5; word-break: break-word; font-size: 14px; mso-line-height-alt: 21px; margin: 0;\"><span style=\"font-size: 14px;\"><strong>Thông tin chi tiết:</strong></span></p>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t<p style=\"line-height: 1.5; word-break: break-word; font-size: 14px; mso-line-height-alt: 21px; margin: 0;\"><span style=\"font-size: 14px;\">Người gửi: <strong>"+sender+"</strong></span></p>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t<p style=\"line-height: 1.5; word-break: break-word; font-size: 14px; mso-line-height-alt: 21px; margin: 0;\"><span style=\"font-size: 14px;\">Người duyệt: <strong>"+approver+"</strong></span></p>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t<p style=\"line-height: 1.5; word-break: break-word; font-size: 14px; mso-line-height-alt: 21px; margin: 0;\"><span style=\"font-size: 14px;\">Quản lí trên một cấp: <strong>"+managerLv2+"</strong></span></p>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t<p style=\"line-height: 1.5; word-break: break-word; font-size: 14px; mso-line-height-alt: 21px; margin: 0;\"><span style=\"font-size: 14px;\">Lý do:&nbsp;<strong>"+reason+"</strong></span></p>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t<p style=\"line-height: 1.5; word-break: break-word; font-size: 14px; mso-line-height-alt: 21px; margin: 0;\"><span style=\"font-size: 14px;\">Miêu tả<strong>: "+description+"</strong></span></p>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t<p style=\"line-height: 1.5; word-break: break-word; font-size: 14px; mso-line-height-alt: 21px; margin: 0;\"><span style=\"font-size: 14px;\">Ngày duyệt:<strong> "+approverDate+"</strong></span></p>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t<p style=\"line-height: 1.5; word-break: break-word; font-size: 14px; mso-line-height-alt: 21px; margin: 0;\"><span style=\"font-size: 14px;\">Ngày bắt đầu nghỉ:<strong> "+dateBegin+"</strong></span></p>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t<p style=\"line-height: 1.5; word-break: break-word; font-size: 14px; mso-line-height-alt: 21px; margin: 0;\"><span style=\"font-size: 14px;\">Ngày kết thúc nghỉ:<strong> "+dateEnd+"</strong></span></p>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t<p style=\"line-height: 1.5; word-break: break-word; font-size: 14px; mso-line-height-alt: 21px; margin: 0;\"><span "+cssStatus+" >Trạng thái:<strong> "+contentStatus+"</strong></span></p>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t<p style=\"line-height: 1.5; word-break: break-word; font-size: 14px; mso-line-height-alt: 21px; margin: 0;\"><span style=\"font-size: 14px;\" >Ghi chú:<strong> "+reasonReject+"</strong></span></p>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t<p style=\"line-height: 1.5; word-break: break-word; mso-line-height-alt: NaNpx; margin: 0;\">&nbsp;</p>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t<p style=\"line-height: 1.5; word-break: break-word; font-size: 14px; mso-line-height-alt: 21px; margin: 0;\"><span style=\"font-size: 14px;\"><strong>Xin cảm ơn!</strong></span></p>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]></td></tr></table><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<table class=\"divider\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;\" role=\"presentation\" valign=\"top\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t<tbody>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t<tr style=\"vertical-align: top;\" valign=\"top\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"divider_inner\" style=\"word-break: break-word; vertical-align: top; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%; padding-top: 30px; padding-right: 10px; padding-bottom: 10px; padding-left: 10px;\" valign=\"top\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<table class=\"divider_content\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-top: 0px solid transparent; width: 100%;\" align=\"center\" role=\"presentation\" valign=\"top\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tbody>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr style=\"vertical-align: top;\" valign=\"top\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td style=\"word-break: break-word; vertical-align: top; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;\" valign=\"top\"><span></span></td>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tbody>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</table>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t</tbody>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t</table>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<!--[if (!mso)&(!IE)]><!-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t\t\t<!--<![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]></td></tr></table></td></tr></table><![endif]-->\n" +
                            "\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t<div style=\"background-color:transparent;\">\n" +
                            "\t\t\t\t\t\t<div class=\"block-grid three-up\" style=\"Margin: 0 auto; min-width: 320px; max-width: 600px; overflow-wrap: break-word; word-wrap: break-word; word-break: break-word; background-color: #525252;\">\n" +
                            "\t\t\t\t\t\t\t<div style=\"border-collapse: collapse;display: table;width: 100%;background-color:#525252;\">\n" +
                            "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"background-color:transparent;\"><tr><td align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px\"><tr class=\"layout-full-width\" style=\"background-color:#525252\"><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]><td align=\"center\" width=\"200\" style=\"background-color:#525252;width:200px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top:0px; padding-bottom:0px;\"><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t<div class=\"col num4\" style=\"max-width: 320px; min-width: 200px; display: table-cell; vertical-align: top; width: 200px;\">\n" +
                            "\t\t\t\t\t\t\t\t\t<div style=\"width:100% !important;\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t<!--[if (!mso)&(!IE)]><!-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t<div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:0px; padding-bottom:0px; padding-right: 0px; padding-left: 0px;\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<!--<![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<table class=\"social_icons\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" role=\"presentation\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" valign=\"top\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t<tbody>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t<tr style=\"vertical-align: top;\" valign=\"top\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td style=\"word-break: break-word; vertical-align: top; padding-top: 15px; padding-right: 0px; padding-bottom: 0px; padding-left: 0px;\" valign=\"top\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<table class=\"social_table\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-tspace: 0; mso-table-rspace: 0; mso-table-bspace: 0; mso-table-lspace: 0;\" valign=\"top\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tbody>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr style=\"vertical-align: top; display: inline-block; text-align: center;\" align=\"center\" valign=\"top\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td style=\"word-break: break-word; vertical-align: top; padding-bottom: 5px; padding-right: 3px; padding-left: 3px;\" valign=\"top\"><a href=\"https://www.facebook.com/\" target=\"_blank\"><img width=\"32\" height=\"32\" src=\"https://d2fi4ri5dhpqd1.cloudfront.net/public/resources/social-networks-icon-sets/t-only-logo-default-gray/facebook@2x.png\" alt=\"Facebook\" title=\"Facebook\" style=\"text-decoration: none; -ms-interpolation-mode: bicubic; height: auto; border: none; display: block;\"></a></td>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td style=\"word-break: break-word; vertical-align: top; padding-bottom: 5px; padding-right: 3px; padding-left: 3px;\" valign=\"top\"><a href=\"https://twitter.com/\" target=\"_blank\"><img width=\"32\" height=\"32\" src=\"https://d2fi4ri5dhpqd1.cloudfront.net/public/resources/social-networks-icon-sets/t-only-logo-default-gray/twitter@2x.png\" alt=\"Twitter\" title=\"Twitter\" style=\"text-decoration: none; -ms-interpolation-mode: bicubic; height: auto; border: none; display: block;\"></a></td>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td style=\"word-break: break-word; vertical-align: top; padding-bottom: 5px; padding-right: 3px; padding-left: 3px;\" valign=\"top\"><a href=\"https://plus.google.com/\" target=\"_blank\"><img width=\"32\" height=\"32\" src=\"https://d2fi4ri5dhpqd1.cloudfront.net/public/resources/social-networks-icon-sets/t-only-logo-default-gray/googleplus@2x.png\" alt=\"Google+\" title=\"Google+\" style=\"text-decoration: none; -ms-interpolation-mode: bicubic; height: auto; border: none; display: block;\"></a></td>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tbody>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</table>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t</tbody>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t</table>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<!--[if (!mso)&(!IE)]><!-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t\t\t<!--<![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]></td><td align=\"center\" width=\"200\" style=\"background-color:#525252;width:200px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top:5px; padding-bottom:5px;\"><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t<div class=\"col num4\" style=\"max-width: 320px; min-width: 200px; display: table-cell; vertical-align: top; width: 200px;\">\n" +
                            "\t\t\t\t\t\t\t\t\t<div style=\"width:100% !important;\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t<!--[if (!mso)&(!IE)]><!-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t<div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:5px; padding-bottom:5px; padding-right: 0px; padding-left: 0px;\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<!--<![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top: 20px; padding-bottom: 0px; font-family: Tahoma, sans-serif\"><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<div style=\"color:#a8bf6f;font-family:Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif;line-height:1.2;padding-top:20px;padding-right:0px;padding-bottom:0px;padding-left:0px;\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"font-size: 12px; line-height: 1.2; color: #a8bf6f; font-family: Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif; mso-line-height-alt: 14px;\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t<p style=\"font-size: 12px; line-height: 1.2; text-align: center; word-break: break-word; mso-line-height-alt: 14px; margin: 0;\"><span style=\"color: #ffffff; font-size: 12px;\"><span style=\"font-size: 12px; color: #a8bf6f;\">Tel.:</span> +(024) - 666 20346</span></p>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]></td></tr></table><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<!--[if (!mso)&(!IE)]><!-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t\t\t<!--<![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]></td><td align=\"center\" width=\"200\" style=\"background-color:#525252;width:200px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top:5px; padding-bottom:5px;\"><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t<div class=\"col num4\" style=\"max-width: 320px; min-width: 200px; display: table-cell; vertical-align: top; width: 200px;\">\n" +
                            "\t\t\t\t\t\t\t\t\t<div style=\"width:100% !important;\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t<!--[if (!mso)&(!IE)]><!-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t<div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:5px; padding-bottom:5px; padding-right: 0px; padding-left: 0px;\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<!--<![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top: 20px; padding-bottom: 0px; font-family: Tahoma, sans-serif\"><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<div style=\"color:#a8bf6f;font-family:Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif;line-height:1.2;padding-top:20px;padding-right:0px;padding-bottom:0px;padding-left:0px;\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"font-size: 12px; line-height: 1.2; color: #a8bf6f; font-family: Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif; mso-line-height-alt: 14px;\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t<p style=\"font-size: 12px; line-height: 1.2; text-align: center; word-break: break-word; mso-line-height-alt: 14px; margin: 0;\">Email&nbsp;<span style=\"color: #ffffff;\">Contact@vissoft.vn</span></p>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]></td></tr></table><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<!--[if (!mso)&(!IE)]><!-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t\t\t<!--<![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]></td></tr></table></td></tr></table><![endif]-->\n" +
                            "\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t<div style=\"background-color:transparent;\">\n" +
                            "\t\t\t\t\t\t<div class=\"block-grid \" style=\"Margin: 0 auto; min-width: 320px; max-width: 600px; overflow-wrap: break-word; word-wrap: break-word; word-break: break-word; background-color: transparent;\">\n" +
                            "\t\t\t\t\t\t\t<div style=\"border-collapse: collapse;display: table;width: 100%;background-color:transparent;\">\n" +
                            "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"background-color:transparent;\"><tr><td align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px\"><tr class=\"layout-full-width\" style=\"background-color:transparent\"><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]><td align=\"center\" width=\"600\" style=\"background-color:transparent;width:600px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top:0px; padding-bottom:5px;\"><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t<div class=\"col num12\" style=\"min-width: 320px; max-width: 600px; display: table-cell; vertical-align: top; width: 600px;\">\n" +
                            "\t\t\t\t\t\t\t\t\t<div style=\"width:100% !important;\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t<!--[if (!mso)&(!IE)]><!-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t<div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:0px; padding-bottom:5px; padding-right: 0px; padding-left: 0px;\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<!--<![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<div class=\"img-container center autowidth\" align=\"center\" style=\"padding-right: 0px;padding-left: 0px;\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr style=\"line-height:0px\"><td style=\"padding-right: 0px;padding-left: 0px;\" align=\"center\"><![endif]--><img class=\"center autowidth\" align=\"center\" border=\"0\" src=\"https://d1oco4z2z1fhwp.cloudfront.net/templates/default/20/rounder-dwn.png\" alt=\"Image\" title=\"Image\" style=\"text-decoration: none; -ms-interpolation-mode: bicubic; border: 0; height: auto; width: 100%; max-width: 600px; display: block;\" width=\"600\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]></td></tr></table><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<table class=\"divider\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;\" role=\"presentation\" valign=\"top\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t<tbody>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t<tr style=\"vertical-align: top;\" valign=\"top\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"divider_inner\" style=\"word-break: break-word; vertical-align: top; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%; padding-top: 30px; padding-right: 30px; padding-bottom: 30px; padding-left: 30px;\" valign=\"top\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<table class=\"divider_content\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-top: 0px solid transparent; width: 100%;\" align=\"center\" role=\"presentation\" valign=\"top\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tbody>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr style=\"vertical-align: top;\" valign=\"top\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td style=\"word-break: break-word; vertical-align: top; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;\" valign=\"top\"><span></span></td>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tbody>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</table>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t</tbody>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t</table>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<!--[if (!mso)&(!IE)]><!-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t\t\t<!--<![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]></td></tr></table></td></tr></table><![endif]-->\n" +
                            "\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n" +
                            "\t\t\t\t</td>\n" +
                            "\t\t\t</tr>\n" +
                            "\t\t</tbody>\n" +
                            "\t</table>\n" +
                            "\t<!--[if (IE)]></div><![endif]-->\n" +
                            "</body>\n" +
                            "\n" +
                            "</html>";
            return emailContentApproved;
        } else {
            cssStatus = "style =\"color:red;\" ";
            contentStatus = "Từ chối";

            String emailContentReject =
                    "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional //EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
                            "<html xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:v=\"urn:schemas-microsoft-com:vml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\">\n" +
                            "\n" +
                            "<head>\n" +
                            "\t<!--[if gte mso 9]><xml><o:OfficeDocumentSettings><o:AllowPNG/><o:PixelsPerInch>96</o:PixelsPerInch></o:OfficeDocumentSettings></xml><![endif]-->\n" +
                            "\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\n" +
                            "\t<meta name=\"viewport\" content=\"width=device-width\">\n" +
                            "\t<!--[if !mso]><!-->\n" +
                            "\t<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
                            "\t<!--<![endif]-->\n" +
                            "\t<title></title>\n" +
                            "\t<!--[if !mso]><!-->\n" +
                            "\t<link href=\"https://fonts.googleapis.com/css?family=Montserrat\" rel=\"stylesheet\" type=\"text/css\">\n" +
                            "\t<!--<![endif]-->\n" +
                            "\t<style type=\"text/css\">\n" +
                            "\t\tbody {\n" +
                            "\t\t\tmargin: 0;\n" +
                            "\t\t\tpadding: 0;\n" +
                            "\t\t}\n" +
                            "\n" +
                            "\t\ttable,\n" +
                            "\t\ttd,\n" +
                            "\t\ttr {\n" +
                            "\t\t\tvertical-align: top;\n" +
                            "\t\t\tborder-collapse: collapse;\n" +
                            "\t\t}\n" +
                            "\n" +
                            "\t\t* {\n" +
                            "\t\t\tline-height: inherit;\n" +
                            "\t\t}\n" +
                            "\n" +
                            "\t\ta[x-apple-data-detectors=true] {\n" +
                            "\t\t\tcolor: inherit !important;\n" +
                            "\t\t\ttext-decoration: none !important;\n" +
                            "\t\t}\n" +
                            "\t</style>\n" +
                            "\t<style type=\"text/css\" id=\"media-query\">\n" +
                            "\t\t@media (max-width: 620px) {\n" +
                            "\n" +
                            "\t\t\t.block-grid,\n" +
                            "\t\t\t.col {\n" +
                            "\t\t\t\tmin-width: 320px !important;\n" +
                            "\t\t\t\tmax-width: 100% !important;\n" +
                            "\t\t\t\tdisplay: block !important;\n" +
                            "\t\t\t}\n" +
                            "\n" +
                            "\t\t\t.block-grid {\n" +
                            "\t\t\t\twidth: 100% !important;\n" +
                            "\t\t\t}\n" +
                            "\n" +
                            "\t\t\t.col {\n" +
                            "\t\t\t\twidth: 100% !important;\n" +
                            "\t\t\t}\n" +
                            "\n" +
                            "\t\t\t.col>div {\n" +
                            "\t\t\t\tmargin: 0 auto;\n" +
                            "\t\t\t}\n" +
                            "\n" +
                            "\t\t\timg.fullwidth,\n" +
                            "\t\t\timg.fullwidthOnMobile {\n" +
                            "\t\t\t\tmax-width: 100% !important;\n" +
                            "\t\t\t}\n" +
                            "\n" +
                            "\t\t\t.no-stack .col {\n" +
                            "\t\t\t\tmin-width: 0 !important;\n" +
                            "\t\t\t\tdisplay: table-cell !important;\n" +
                            "\t\t\t}\n" +
                            "\n" +
                            "\t\t\t.no-stack.two-up .col {\n" +
                            "\t\t\t\twidth: 50% !important;\n" +
                            "\t\t\t}\n" +
                            "\n" +
                            "\t\t\t.no-stack .col.num4 {\n" +
                            "\t\t\t\twidth: 33% !important;\n" +
                            "\t\t\t}\n" +
                            "\n" +
                            "\t\t\t.no-stack .col.num8 {\n" +
                            "\t\t\t\twidth: 66% !important;\n" +
                            "\t\t\t}\n" +
                            "\n" +
                            "\t\t\t.no-stack .col.num4 {\n" +
                            "\t\t\t\twidth: 33% !important;\n" +
                            "\t\t\t}\n" +
                            "\n" +
                            "\t\t\t.no-stack .col.num3 {\n" +
                            "\t\t\t\twidth: 25% !important;\n" +
                            "\t\t\t}\n" +
                            "\n" +
                            "\t\t\t.no-stack .col.num6 {\n" +
                            "\t\t\t\twidth: 50% !important;\n" +
                            "\t\t\t}\n" +
                            "\n" +
                            "\t\t\t.no-stack .col.num9 {\n" +
                            "\t\t\t\twidth: 75% !important;\n" +
                            "\t\t\t}\n" +
                            "\n" +
                            "\t\t\t.video-block {\n" +
                            "\t\t\t\tmax-width: none !important;\n" +
                            "\t\t\t}\n" +
                            "\n" +
                            "\t\t\t.mobile_hide {\n" +
                            "\t\t\t\tmin-height: 0px;\n" +
                            "\t\t\t\tmax-height: 0px;\n" +
                            "\t\t\t\tmax-width: 0px;\n" +
                            "\t\t\t\tdisplay: none;\n" +
                            "\t\t\t\toverflow: hidden;\n" +
                            "\t\t\t\tfont-size: 0px;\n" +
                            "\t\t\t}\n" +
                            "\n" +
                            "\t\t\t.desktop_hide {\n" +
                            "\t\t\t\tdisplay: block !important;\n" +
                            "\t\t\t\tmax-height: none !important;\n" +
                            "\t\t\t}\n" +
                            "\t\t}\n" +
                            "\t</style>\n" +
                            "</head>\n" +
                            "\n" +
                            "<body class=\"clean-body\" style=\"margin: 0; padding: 0; -webkit-text-size-adjust: 100%; background-color: #e2eace;\">\n" +
                            "\t<!--[if IE]><div class=\"ie-browser\"><![endif]-->\n" +
                            "\t<table class=\"nl-container\" style=\"table-layout: fixed; vertical-align: top; min-width: 320px; Margin: 0 auto; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #e2eace; width: 100%;\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" width=\"100%\" bgcolor=\"#e2eace\" valign=\"top\">\n" +
                            "\t\t<tbody>\n" +
                            "\t\t\t<tr style=\"vertical-align: top;\" valign=\"top\">\n" +
                            "\t\t\t\t<td style=\"word-break: break-word; vertical-align: top;\" valign=\"top\">\n" +
                            "\t\t\t\t\t<!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td align=\"center\" style=\"background-color:#e2eace\"><![endif]-->\n" +
                            "\t\t\t\t\t<div style=\"background-color:transparent;\">\n" +
                            "\t\t\t\t\t\t<div class=\"block-grid \" style=\"Margin: 0 auto; min-width: 320px; max-width: 600px; overflow-wrap: break-word; word-wrap: break-word; word-break: break-word; background-color: transparent;\">\n" +
                            "\t\t\t\t\t\t\t<div style=\"border-collapse: collapse;display: table;width: 100%;background-color:transparent;\">\n" +
                            "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"background-color:transparent;\"><tr><td align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px\"><tr class=\"layout-full-width\" style=\"background-color:transparent\"><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]><td align=\"center\" width=\"600\" style=\"background-color:transparent;width:600px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top:5px; padding-bottom:0px;\"><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t<div class=\"col num12\" style=\"min-width: 320px; max-width: 600px; display: table-cell; vertical-align: top; width: 600px;\">\n" +
                            "\t\t\t\t\t\t\t\t\t<div style=\"width:100% !important;\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t<!--[if (!mso)&(!IE)]><!-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t<div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:5px; padding-bottom:0px; padding-right: 0px; padding-left: 0px;\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<!--<![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<div class=\"img-container center autowidth\" align=\"center\" style=\"padding-right: 0px;padding-left: 0px;\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr style=\"line-height:0px\"><td style=\"padding-right: 0px;padding-left: 0px;\" align=\"center\"><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"font-size:1px;line-height:25px\">&nbsp;</div><img class=\"center autowidth\" align=\"center\" border=\"0\" src=\"https://d1oco4z2z1fhwp.cloudfront.net/templates/default/20/rounder-up.png\" alt=\"Image\" title=\"Image\" style=\"text-decoration: none; -ms-interpolation-mode: bicubic; border: 0; height: auto; width: 100%; max-width: 600px; display: block;\" width=\"600\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]></td></tr></table><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<!--[if (!mso)&(!IE)]><!-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t\t\t<!--<![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]></td></tr></table></td></tr></table><![endif]-->\n" +
                            "\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t<div style=\"background-color:transparent;\">\n" +
                            "\t\t\t\t\t\t<div class=\"block-grid \" style=\"Margin: 0 auto; min-width: 320px; max-width: 600px; overflow-wrap: break-word; word-wrap: break-word; word-break: break-word; background-color: #FFFFFF;\">\n" +
                            "\t\t\t\t\t\t\t<div style=\"border-collapse: collapse;display: table;width: 100%;background-color:#FFFFFF;\">\n" +
                            "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"background-color:transparent;\"><tr><td align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px\"><tr class=\"layout-full-width\" style=\"background-color:#FFFFFF\"><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]><td align=\"center\" width=\"600\" style=\"background-color:#FFFFFF;width:600px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top:5px; padding-bottom:5px;\"><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t<div class=\"col num12\" style=\"min-width: 320px; max-width: 600px; display: table-cell; vertical-align: top; width: 600px;\">\n" +
                            "\t\t\t\t\t\t\t\t\t<div style=\"width:100% !important;\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t<!--[if (!mso)&(!IE)]><!-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t<div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:5px; padding-bottom:5px; padding-right: 0px; padding-left: 0px;\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<!--<![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<div class=\"img-container center\" align=\"center\" style=\"padding-right: 0px;padding-left: 0px;\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr style=\"line-height:0px\"><td style=\"padding-right: 0px;padding-left: 0px;\" align=\"center\"><![endif]--><img class=\"center\" align=\"center\" border=\"0\" src=\"https://cdn.itviec.com/employers/vis-soft/logo/social/DXErnqbxaE5NmyzrCp8EBBYG/vis-soft-logo.png\" alt=\"Image\" title=\"Image\" style=\"text-decoration: none; -ms-interpolation-mode: bicubic; border: 0; height: auto; width: 100%; max-width: 150px; display: block;\" width=\"150\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]></td></tr></table><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 10px; padding-left: 10px; padding-top: 10px; padding-bottom: 10px; font-family: Tahoma, sans-serif\"><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<div style=\"color:#555555;font-family:Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif;line-height:1.5;padding-top:10px;padding-right:10px;padding-bottom:10px;padding-left:10px;\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"font-size: 12px; line-height: 1.5; color: #555555; font-family: Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif; mso-line-height-alt: 18px;\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t<p style=\"font-size: 14px; line-height: 1.5; text-align: center; word-break: break-word; mso-line-height-alt: 21px; margin: 0;\">Công ty Cổ Phần Công Nghệ Và Truyền Thông VIS</p>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]></td></tr></table><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<!--[if (!mso)&(!IE)]><!-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t\t\t<!--<![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]></td></tr></table></td></tr></table><![endif]-->\n" +
                            "\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t<div style=\"background-color:transparent;\">\n" +
                            "\t\t\t\t\t\t<div class=\"block-grid \" style=\"Margin: 0 auto; min-width: 320px; max-width: 600px; overflow-wrap: break-word; word-wrap: break-word; word-break: break-word; background-color: #FFFFFF;\">\n" +
                            "\t\t\t\t\t\t\t<div style=\"border-collapse: collapse;display: table;width: 100%;background-color:#FFFFFF;\">\n" +
                            "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"background-color:transparent;\"><tr><td align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px\"><tr class=\"layout-full-width\" style=\"background-color:#FFFFFF\"><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]><td align=\"center\" width=\"600\" style=\"background-color:#FFFFFF;width:600px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top:0px; padding-bottom:5px;\"><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t<div class=\"col num12\" style=\"min-width: 320px; max-width: 600px; display: table-cell; vertical-align: top; width: 600px;\">\n" +
                            "\t\t\t\t\t\t\t\t\t<div style=\"width:100% !important;\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t<!--[if (!mso)&(!IE)]><!-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t<div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:0px; padding-bottom:5px; padding-right: 0px; padding-left: 0px;\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<!--<![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 10px; padding-left: 10px; padding-top: 10px; padding-bottom: 10px; font-family: Tahoma, sans-serif\"><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<div style=\"color:#0D0D0D;font-family:Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif;line-height:1.2;padding-top:10px;padding-right:10px;padding-bottom:10px;padding-left:10px;\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"font-size: 12px; line-height: 1.2; color: #0D0D0D; font-family: Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif; mso-line-height-alt: 14px;\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t<p style=\"font-size: 28px; line-height: 1.2; text-align: center; word-break: break-word; mso-line-height-alt: 34px; margin: 0;\"><span style=\"font-size: 28px;\"><strong>Thông báo nghỉ phép</strong></span></p>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]></td></tr></table><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<div class=\"img-container center\" align=\"center\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr style=\"line-height:0px\"><td style=\"\" align=\"center\"><![endif]--><img class=\"center\" align=\"center\" border=\"0\" src=\"https://d1oco4z2z1fhwp.cloudfront.net/templates/default/20/divider.png\" alt=\"Image\" title=\"Image\" style=\"text-decoration: none; -ms-interpolation-mode: bicubic; border: 0; height: auto; width: 100%; max-width: 318px; display: block;\" width=\"318\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]></td></tr></table><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 10px; padding-left: 10px; padding-top: 10px; padding-bottom: 10px; font-family: Tahoma, sans-serif\"><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<div style=\"color:#555555;font-family:Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif;line-height:1.5;padding-top:10px;padding-right:10px;padding-bottom:10px;padding-left:10px;\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"font-size: 12px; line-height: 1.5; color: #555555; font-family: Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif; mso-line-height-alt: 18px;\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t<p style=\"font-size: 14px; line-height: 1.5; text-align: center; word-break: break-word; mso-line-height-alt: 21px; margin: 0;\"><span style=\"color: #a8bf6f; font-size: 14px;\"><strong>Đơn xin đăng kí giờ làm của "+ sender + " đã được "+approver+" duyệt</strong></span></p>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]></td></tr></table><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 10px; padding-left: 10px; padding-top: 20px; padding-bottom: 10px; font-family: Tahoma, sans-serif\"><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<div style=\"color:#0D0D0D;font-family:Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif;line-height:1.5;padding-top:20px;padding-right:10px;padding-bottom:10px;padding-left:10px;\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"line-height: 1.5; font-size: 12px; color: #0D0D0D; font-family: Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif; mso-line-height-alt: 18px;\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t<p style=\"line-height: 1.5; word-break: break-word; font-size: 14px; mso-line-height-alt: 21px; margin: 0;\"><span style=\"font-size: 14px;\"><strong>Thông tin chi tiết:</strong></span></p>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t<p style=\"line-height: 1.5; word-break: break-word; font-size: 14px; mso-line-height-alt: 21px; margin: 0;\"><span style=\"font-size: 14px;\">Người gửi: <strong>"+sender+"</strong></span></p>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t<p style=\"line-height: 1.5; word-break: break-word; font-size: 14px; mso-line-height-alt: 21px; margin: 0;\"><span style=\"font-size: 14px;\">Người duyệt: <strong>"+approver+"</strong></span></p>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t<p style=\"line-height: 1.5; word-break: break-word; font-size: 14px; mso-line-height-alt: 21px; margin: 0;\"><span style=\"font-size: 14px;\">Quản lí trên một cấp: <strong>"+managerLv2+"</strong></span></p>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t<p style=\"line-height: 1.5; word-break: break-word; font-size: 14px; mso-line-height-alt: 21px; margin: 0;\"><span style=\"font-size: 14px;\">Lý do:&nbsp;<strong>"+reason+"</strong></span></p>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t<p style=\"line-height: 1.5; word-break: break-word; font-size: 14px; mso-line-height-alt: 21px; margin: 0;\"><span style=\"font-size: 14px;\">Miêu tả<strong>: "+description+"</strong></span></p>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t<p style=\"line-height: 1.5; word-break: break-word; font-size: 14px; mso-line-height-alt: 21px; margin: 0;\"><span style=\"font-size: 14px;\">Ngày duyệt:<strong> "+approverDate+"</strong></span></p>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t<p style=\"line-height: 1.5; word-break: break-word; font-size: 14px; mso-line-height-alt: 21px; margin: 0;\"><span style=\"font-size: 14px;\">Ngày bắt đầu nghỉ:<strong> "+dateBegin+"</strong></span></p>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t<p style=\"line-height: 1.5; word-break: break-word; font-size: 14px; mso-line-height-alt: 21px; margin: 0;\"><span style=\"font-size: 14px;\">Ngày kết thúc nghỉ:<strong> "+dateEnd+"</strong></span></p>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t<p style=\"line-height: 1.5; word-break: break-word; font-size: 14px; mso-line-height-alt: 21px; margin: 0;\"><span "+cssStatus+" >Trạng thái:<strong> "+contentStatus+"</strong></span></p>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t<p style=\"line-height: 1.5; word-break: break-word; font-size: 14px; mso-line-height-alt: 21px; margin: 0;\"><span style=\"font-size: 14px;\" >Ghi chú:<strong> "+reasonReject+"</strong></span></p>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t<p style=\"line-height: 1.5; word-break: break-word; mso-line-height-alt: NaNpx; margin: 0;\">&nbsp;</p>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t<p style=\"line-height: 1.5; word-break: break-word; font-size: 14px; mso-line-height-alt: 21px; margin: 0;\"><span style=\"font-size: 14px;\"><strong>Xin cảm ơn!</strong></span></p>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]></td></tr></table><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<table class=\"divider\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;\" role=\"presentation\" valign=\"top\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t<tbody>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t<tr style=\"vertical-align: top;\" valign=\"top\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"divider_inner\" style=\"word-break: break-word; vertical-align: top; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%; padding-top: 30px; padding-right: 10px; padding-bottom: 10px; padding-left: 10px;\" valign=\"top\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<table class=\"divider_content\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-top: 0px solid transparent; width: 100%;\" align=\"center\" role=\"presentation\" valign=\"top\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tbody>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr style=\"vertical-align: top;\" valign=\"top\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td style=\"word-break: break-word; vertical-align: top; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;\" valign=\"top\"><span></span></td>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tbody>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</table>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t</tbody>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t</table>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<!--[if (!mso)&(!IE)]><!-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t\t\t<!--<![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]></td></tr></table></td></tr></table><![endif]-->\n" +
                            "\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t<div style=\"background-color:transparent;\">\n" +
                            "\t\t\t\t\t\t<div class=\"block-grid three-up\" style=\"Margin: 0 auto; min-width: 320px; max-width: 600px; overflow-wrap: break-word; word-wrap: break-word; word-break: break-word; background-color: #525252;\">\n" +
                            "\t\t\t\t\t\t\t<div style=\"border-collapse: collapse;display: table;width: 100%;background-color:#525252;\">\n" +
                            "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"background-color:transparent;\"><tr><td align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px\"><tr class=\"layout-full-width\" style=\"background-color:#525252\"><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]><td align=\"center\" width=\"200\" style=\"background-color:#525252;width:200px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top:0px; padding-bottom:0px;\"><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t<div class=\"col num4\" style=\"max-width: 320px; min-width: 200px; display: table-cell; vertical-align: top; width: 200px;\">\n" +
                            "\t\t\t\t\t\t\t\t\t<div style=\"width:100% !important;\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t<!--[if (!mso)&(!IE)]><!-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t<div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:0px; padding-bottom:0px; padding-right: 0px; padding-left: 0px;\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<!--<![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<table class=\"social_icons\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" role=\"presentation\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" valign=\"top\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t<tbody>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t<tr style=\"vertical-align: top;\" valign=\"top\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td style=\"word-break: break-word; vertical-align: top; padding-top: 15px; padding-right: 0px; padding-bottom: 0px; padding-left: 0px;\" valign=\"top\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<table class=\"social_table\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-tspace: 0; mso-table-rspace: 0; mso-table-bspace: 0; mso-table-lspace: 0;\" valign=\"top\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tbody>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr style=\"vertical-align: top; display: inline-block; text-align: center;\" align=\"center\" valign=\"top\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td style=\"word-break: break-word; vertical-align: top; padding-bottom: 5px; padding-right: 3px; padding-left: 3px;\" valign=\"top\"><a href=\"https://www.facebook.com/\" target=\"_blank\"><img width=\"32\" height=\"32\" src=\"https://d2fi4ri5dhpqd1.cloudfront.net/public/resources/social-networks-icon-sets/t-only-logo-default-gray/facebook@2x.png\" alt=\"Facebook\" title=\"Facebook\" style=\"text-decoration: none; -ms-interpolation-mode: bicubic; height: auto; border: none; display: block;\"></a></td>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td style=\"word-break: break-word; vertical-align: top; padding-bottom: 5px; padding-right: 3px; padding-left: 3px;\" valign=\"top\"><a href=\"https://twitter.com/\" target=\"_blank\"><img width=\"32\" height=\"32\" src=\"https://d2fi4ri5dhpqd1.cloudfront.net/public/resources/social-networks-icon-sets/t-only-logo-default-gray/twitter@2x.png\" alt=\"Twitter\" title=\"Twitter\" style=\"text-decoration: none; -ms-interpolation-mode: bicubic; height: auto; border: none; display: block;\"></a></td>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td style=\"word-break: break-word; vertical-align: top; padding-bottom: 5px; padding-right: 3px; padding-left: 3px;\" valign=\"top\"><a href=\"https://plus.google.com/\" target=\"_blank\"><img width=\"32\" height=\"32\" src=\"https://d2fi4ri5dhpqd1.cloudfront.net/public/resources/social-networks-icon-sets/t-only-logo-default-gray/googleplus@2x.png\" alt=\"Google+\" title=\"Google+\" style=\"text-decoration: none; -ms-interpolation-mode: bicubic; height: auto; border: none; display: block;\"></a></td>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tbody>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</table>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t</tbody>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t</table>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<!--[if (!mso)&(!IE)]><!-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t\t\t<!--<![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]></td><td align=\"center\" width=\"200\" style=\"background-color:#525252;width:200px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top:5px; padding-bottom:5px;\"><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t<div class=\"col num4\" style=\"max-width: 320px; min-width: 200px; display: table-cell; vertical-align: top; width: 200px;\">\n" +
                            "\t\t\t\t\t\t\t\t\t<div style=\"width:100% !important;\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t<!--[if (!mso)&(!IE)]><!-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t<div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:5px; padding-bottom:5px; padding-right: 0px; padding-left: 0px;\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<!--<![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top: 20px; padding-bottom: 0px; font-family: Tahoma, sans-serif\"><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<div style=\"color:#a8bf6f;font-family:Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif;line-height:1.2;padding-top:20px;padding-right:0px;padding-bottom:0px;padding-left:0px;\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"font-size: 12px; line-height: 1.2; color: #a8bf6f; font-family: Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif; mso-line-height-alt: 14px;\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t<p style=\"font-size: 12px; line-height: 1.2; text-align: center; word-break: break-word; mso-line-height-alt: 14px; margin: 0;\"><span style=\"color: #ffffff; font-size: 12px;\"><span style=\"font-size: 12px; color: #a8bf6f;\">Tel.:</span> +(024) - 666 20346</span></p>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]></td></tr></table><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<!--[if (!mso)&(!IE)]><!-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t\t\t<!--<![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]></td><td align=\"center\" width=\"200\" style=\"background-color:#525252;width:200px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top:5px; padding-bottom:5px;\"><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t<div class=\"col num4\" style=\"max-width: 320px; min-width: 200px; display: table-cell; vertical-align: top; width: 200px;\">\n" +
                            "\t\t\t\t\t\t\t\t\t<div style=\"width:100% !important;\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t<!--[if (!mso)&(!IE)]><!-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t<div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:5px; padding-bottom:5px; padding-right: 0px; padding-left: 0px;\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<!--<![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top: 20px; padding-bottom: 0px; font-family: Tahoma, sans-serif\"><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<div style=\"color:#a8bf6f;font-family:Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif;line-height:1.2;padding-top:20px;padding-right:0px;padding-bottom:0px;padding-left:0px;\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"font-size: 12px; line-height: 1.2; color: #a8bf6f; font-family: Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif; mso-line-height-alt: 14px;\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t<p style=\"font-size: 12px; line-height: 1.2; text-align: center; word-break: break-word; mso-line-height-alt: 14px; margin: 0;\">Email&nbsp;<span style=\"color: #ffffff;\">Contact@vissoft.vn</span></p>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]></td></tr></table><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<!--[if (!mso)&(!IE)]><!-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t\t\t<!--<![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]></td></tr></table></td></tr></table><![endif]-->\n" +
                            "\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t<div style=\"background-color:transparent;\">\n" +
                            "\t\t\t\t\t\t<div class=\"block-grid \" style=\"Margin: 0 auto; min-width: 320px; max-width: 600px; overflow-wrap: break-word; word-wrap: break-word; word-break: break-word; background-color: transparent;\">\n" +
                            "\t\t\t\t\t\t\t<div style=\"border-collapse: collapse;display: table;width: 100%;background-color:transparent;\">\n" +
                            "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"background-color:transparent;\"><tr><td align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px\"><tr class=\"layout-full-width\" style=\"background-color:transparent\"><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]><td align=\"center\" width=\"600\" style=\"background-color:transparent;width:600px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top:0px; padding-bottom:5px;\"><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t<div class=\"col num12\" style=\"min-width: 320px; max-width: 600px; display: table-cell; vertical-align: top; width: 600px;\">\n" +
                            "\t\t\t\t\t\t\t\t\t<div style=\"width:100% !important;\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t<!--[if (!mso)&(!IE)]><!-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t<div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:0px; padding-bottom:5px; padding-right: 0px; padding-left: 0px;\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<!--<![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<div class=\"img-container center autowidth\" align=\"center\" style=\"padding-right: 0px;padding-left: 0px;\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr style=\"line-height:0px\"><td style=\"padding-right: 0px;padding-left: 0px;\" align=\"center\"><![endif]--><img class=\"center autowidth\" align=\"center\" border=\"0\" src=\"https://d1oco4z2z1fhwp.cloudfront.net/templates/default/20/rounder-dwn.png\" alt=\"Image\" title=\"Image\" style=\"text-decoration: none; -ms-interpolation-mode: bicubic; border: 0; height: auto; width: 100%; max-width: 600px; display: block;\" width=\"600\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t<!--[if mso]></td></tr></table><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<table class=\"divider\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;\" role=\"presentation\" valign=\"top\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t<tbody>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t<tr style=\"vertical-align: top;\" valign=\"top\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"divider_inner\" style=\"word-break: break-word; vertical-align: top; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%; padding-top: 30px; padding-right: 30px; padding-bottom: 30px; padding-left: 30px;\" valign=\"top\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<table class=\"divider_content\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-top: 0px solid transparent; width: 100%;\" align=\"center\" role=\"presentation\" valign=\"top\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tbody>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr style=\"vertical-align: top;\" valign=\"top\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td style=\"word-break: break-word; vertical-align: top; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;\" valign=\"top\"><span></span></td>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tbody>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</table>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t</tbody>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t</table>\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t<!--[if (!mso)&(!IE)]><!-->\n" +
                            "\t\t\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t\t\t<!--<![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n" +
                            "\t\t\t\t\t\t\t\t<!--[if (mso)|(IE)]></td></tr></table></td></tr></table><![endif]-->\n" +
                            "\t\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n" +
                            "\t\t\t\t</td>\n" +
                            "\t\t\t</tr>\n" +
                            "\t\t</tbody>\n" +
                            "\t</table>\n" +
                            "\t<!--[if (IE)]></div><![endif]-->\n" +
                            "</body>\n" +
                            "\n" +
                            "</html>";
            return emailContentReject;
        }
    }
}
