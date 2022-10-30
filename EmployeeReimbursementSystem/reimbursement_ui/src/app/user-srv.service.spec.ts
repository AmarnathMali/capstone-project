import { TestBed } from '@angular/core/testing';

import { UserSrvService } from './user-srv.service';

describe('UserSrvService', () => {
  let service: UserSrvService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(UserSrvService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
