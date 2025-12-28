@Autowired
public OverflowPredictionServiceImpl(
        BinRepository binRepository,
        FillLevelRecordRepository recordRepository,
        UsagePatternModelRepository modelRepository,
        OverflowPredictionRepository predictionRepository,
        ZoneRepository zoneRepository) {

    this.binRepository = binRepository;
    this.recordRepository = recordRepository;
    this.modelRepository = modelRepository;
    this.predictionRepository = predictionRepository;
    this.zoneRepository = zoneRepository;
}
