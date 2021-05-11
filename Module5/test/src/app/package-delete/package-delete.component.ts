import {Component, Inject, OnInit} from '@angular/core';
import {PackageService} from '../service/package.service';
import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material/dialog';
import {Router} from '@angular/router';

@Component({
  selector: 'app-package-delete',
  templateUrl: './package-delete.component.html',
  styleUrls: ['./package-delete.component.scss']
})
export class PackageDeleteComponent implements OnInit {

  constructor(private packageService: PackageService,
              @Inject(MAT_DIALOG_DATA) public data: any,
              public dialogRef: MatDialogRef<PackageDeleteComponent>,
              public router: Router) {
  }
  package;
  ngOnInit(): void {
    this.package = this.data.dataC;
  }

  deletePackage() {
    this.packageService.deletePackage(this.data.dataC).subscribe(data => {
      this.router.navigate(['package'], {queryParams: {messageDelete: 'Delete Successfully !!!', si: true}});
      this.dialogRef.close();
    }, error => {
      console.log(error);
    });
  }
}
