object ConsEtiqueta: TConsEtiqueta
  Left = 202
  Top = 161
  Width = 696
  Height = 480
  Caption = 'ConsEtiqueta'
  Color = clBtnFace
  Font.Charset = DEFAULT_CHARSET
  Font.Color = clWindowText
  Font.Height = -11
  Font.Name = 'MS Sans Serif'
  Font.Style = []
  OldCreateOrder = False
  PixelsPerInch = 96
  TextHeight = 13
  object DBGrid1: TDBGrid
    Left = 0
    Top = 96
    Width = 688
    Height = 350
    Align = alBottom
    DataSource = DataModule2.dsETIQUETA
    TabOrder = 0
    TitleFont.Charset = DEFAULT_CHARSET
    TitleFont.Color = clWindowText
    TitleFont.Height = -11
    TitleFont.Name = 'MS Sans Serif'
    TitleFont.Style = []
  end
end
