package com.amitsahoo.springsojourn.service;

import com.amitsahoo.springsojourn.entity.Release;
import java.util.List;

public interface ReleaseService {
  List<Release> findReleases();
  
  Release findRelease(Long paramLong);
  
  Long countReleases();
}



