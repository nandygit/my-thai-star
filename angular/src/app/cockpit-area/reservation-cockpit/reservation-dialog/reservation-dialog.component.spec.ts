import { HttpClient } from '@angular/common/http';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { async, TestBed } from '@angular/core/testing';
import { MatDialog } from '@angular/material';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { TranslateModule } from '@ngx-translate/core';
import { CoreModule } from '../../../core/core.module';
import { PriceCalculatorService } from '../../../sidenav/services/price-calculator.service';
import { WaiterCockpitModule } from '../../cockpit.module';
import { WaiterCockpitService } from '../../services/waiter-cockpit.service';
import { ReservationDialogComponent } from './reservation-dialog.component';
import { provideMockStore } from '@ngrx/store/testing';
import { ConfigService } from '../../../core/config/config.service';
import { config } from '../../../core/config/config';

describe('ReservationDialogComponent', () => {
  let component: ReservationDialogComponent;
  let dialog: MatDialog;
  let initialState;

  beforeEach(async(() => {
    initialState = { config };
    TestBed.configureTestingModule({
      providers: [
        WaiterCockpitService,
        provideMockStore({ initialState }),
        ConfigService,
        PriceCalculatorService,
        HttpClient,
      ],
      imports: [
        BrowserAnimationsModule,
        WaiterCockpitModule,
        TranslateModule.forRoot(),
        CoreModule,
        HttpClientTestingModule,
      ],
    }).compileComponents();
  }));

  beforeEach(() => {
    dialog = TestBed.get(MatDialog);
    component = dialog.open(ReservationDialogComponent, {
      data: { dialogData: { row: undefined } },
    }).componentInstance;
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
