import { Injectable } from '@angular/core';
import { MessageService } from 'primeng/api';

@Injectable()
export class ToastService {

  constructor(private toastMessageService: MessageService) { }

  public showSuccessMessage(message: string): void {
    this.toastMessageService.clear();
    this.toastMessageService.add({
      severity: 'success',
      summary: 'Success',
      detail: message,
    });
  }

  public showErrorMessage(message: string): void {
    this.toastMessageService.clear();
    this.toastMessageService.add({
      severity: 'error',
      summary: 'Error',
      detail: message,
    });
  }

  public showConfirm() {
    this.toastMessageService.clear();
    this.toastMessageService.add({key: 'c', sticky: true, severity:'info', summary:'You are going to book animal',
      detail:'Confirm to proceed'});
  }

  public onConfirm() {
    this.toastMessageService.clear('c');
  }

  public onReject() {
    this.toastMessageService.clear('c');
  }
}
