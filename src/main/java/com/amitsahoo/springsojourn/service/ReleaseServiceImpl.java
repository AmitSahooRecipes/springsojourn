package com.amitsahoo.springsojourn.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amitsahoo.springsojourn.entity.Release;
import com.amitsahoo.springsojourn.exception.ReleaseNotFoundException;
import com.amitsahoo.springsojourn.repository.ReleaseRepository;

@Service
public class ReleaseServiceImpl implements ReleaseService {
   @Autowired
   ReleaseRepository releaseRepository;

   public List<Release> findReleases() {
      return (List<Release>) this.releaseRepository.findAll();
   }

   public Release findRelease(Long id) {
      Optional<Release> optionalReleaseRepository = this.releaseRepository.findById(id);
      if (optionalReleaseRepository.isPresent()) {
         return optionalReleaseRepository.get();
      }
      throw new ReleaseNotFoundException("Release Not Found");
   }

   public Long countReleases() {
      return Long.valueOf(this.releaseRepository.count());
   }
}
