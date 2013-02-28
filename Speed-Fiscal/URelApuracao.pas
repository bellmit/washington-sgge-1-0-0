unit URelApuracao;

interface

uses
  Windows, Messages, SysUtils, Variants, Classes, Graphics, Controls, Forms,
  Dialogs, DB, IBCustomDataSet, IBQuery, Buttons, CellEditors, StdCtrls,
  ExtCtrls;

type
  TRelApuSaidas = class(TForm)
    Panel1: TPanel;
    Label1: TLabel;
    DatePickerEditor1: TDatePickerEditor;
    Label2: TLabel;
    Label3: TLabel;
    DatePickerEditor2: TDatePickerEditor;
    SpeedButton1: TSpeedButton;
    QryConsProd: TIBQuery;
    IBQuery1: TIBQuery;
    IBQuery2: TIBQuery;
    IBQuery3: TIBQuery;
    DataSource1: TDataSource;
    procedure SpeedButton1Click(Sender: TObject);
  private
    { Private declarations }
  public
    { Public declarations }
  end;

var
  RelApuSaidas: TRelApuSaidas;

implementation

uses URelVendDiaria;

{$R *.dfm}

procedure TRelApuSaidas.SpeedButton1Click(Sender: TObject);
begin
IBQuery3.Active := false;
IBQuery3.ParamByName('dtinicial').AsDate := DatePickerEditor1.Date;
IBQuery3.ParamByName('dtfinal').AsDate := DatePickerEditor2.Date ;
IBQuery3.Active := true;
RelVendDia.RLReport1.Preview();
end;

end.
