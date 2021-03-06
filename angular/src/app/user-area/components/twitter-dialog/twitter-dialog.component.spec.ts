import { async, TestBed } from '@angular/core/testing';
import { MatDialog } from '@angular/material';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { EffectsModule } from '@ngrx/effects';
import { StoreModule } from '@ngrx/store';
import { TranslateModule } from '@ngx-translate/core';
import { CoreModule } from '../../../core/core.module';
import * as fromRoot from '../../store/reducers';
import { UserAreaModule } from '../../user-area.module';
import { TwitterDialogComponent } from './twitter-dialog.component';
import { RouterTestingModule } from '@angular/router/testing';

describe('TwitterDialogComponent', () => {
  let component: TwitterDialogComponent;
  let dialog: MatDialog;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      imports: [
        RouterTestingModule,
        CoreModule,
        TranslateModule.forRoot(),
        BrowserAnimationsModule,
        UserAreaModule,
        EffectsModule.forRoot([]),
        StoreModule.forRoot(fromRoot.reducers, {
          runtimeChecks: {
            strictStateImmutability: true,
            strictActionImmutability: true,
          },
        }),
      ],
    }).compileComponents();
  }));

  beforeEach(() => {
    dialog = TestBed.get(MatDialog);
    component = dialog.open(TwitterDialogComponent).componentInstance;
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
