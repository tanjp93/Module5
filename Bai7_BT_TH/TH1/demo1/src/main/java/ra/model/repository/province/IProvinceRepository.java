package ra.model.repository.province;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ra.model.entity.Province;

@Repository
public interface IProvinceRepository extends PagingAndSortingRepository<Province,Long> {
}
