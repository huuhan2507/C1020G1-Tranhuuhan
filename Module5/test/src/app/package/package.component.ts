import {Component, OnInit} from '@angular/core';
import {PackageService} from '../service/package.service';
import {MatDialog} from '@angular/material/dialog';
import {PackageDeleteComponent} from '../package-delete/package-delete.component';
import {Package} from '../model/package';

@Component({
  selector: 'app-package',
  templateUrl: './package.component.html',
  styleUrls: ['./package.component.scss']
})
export class PackageComponent implements OnInit {

  constructor(private packageService: PackageService, private dialog: MatDialog) {
  }

  package;
  packageList;
  p: 1;

  ngOnInit(): void {
    this.packageService.getAllPackage().subscribe((data) => {
      this.packageList = data;
    });
  }

  OpenDialogDelete(pack) {
    const dialogRef = this.dialog.open(PackageDeleteComponent, {
      width: '830px',
      height: '600px',
      data: {dataC: pack},
      disableClose: true
    });
    dialogRef.afterClosed().subscribe(result => {
      this.ngOnInit();
    });
  }
}
