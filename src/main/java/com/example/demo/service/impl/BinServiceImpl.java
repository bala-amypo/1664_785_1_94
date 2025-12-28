@Service
public class BinServiceImpl {

    private final BinRepository binRepository;
    private final ZoneRepository zoneRepository;

    public BinServiceImpl(BinRepository binRepository,
                          ZoneRepository zoneRepository) {
        this.binRepository = binRepository;
        this.zoneRepository = zoneRepository;
    }

    public Bin createBin(Bin bin) {
        return binRepository.save(bin);
    }

    public void deactivateBin(long id) {
        Bin bin = binRepository.findById(id).orElse(null);
        if (bin != null) {
            bin.setActive(false);
            binRepository.save(bin);
        }
    }
}
