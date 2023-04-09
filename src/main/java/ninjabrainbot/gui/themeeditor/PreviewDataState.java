package ninjabrainbot.gui.themeeditor;

import java.util.List;

import ninjabrainbot.data.IDataState;
import ninjabrainbot.data.ResultType;
import ninjabrainbot.data.calculator.ICalculatorResult;
import ninjabrainbot.data.calculator.alladvancements.AllAdvancementsDataState;
import ninjabrainbot.data.calculator.alladvancements.IAllAdvancementsDataState;
import ninjabrainbot.data.calculator.blind.BlindResult;
import ninjabrainbot.data.calculator.common.IPlayerPosition;
import ninjabrainbot.data.calculator.divine.DivineContext;
import ninjabrainbot.data.calculator.divine.DivineResult;
import ninjabrainbot.data.calculator.divine.Fossil;
import ninjabrainbot.data.calculator.divine.IDivineContext;
import ninjabrainbot.data.calculator.endereye.IEnderEyeThrow;
import ninjabrainbot.data.calculator.highprecision.BoatDataState;
import ninjabrainbot.data.calculator.highprecision.IBoatDataState;
import ninjabrainbot.data.calculator.stronghold.ChunkPrediction;
import ninjabrainbot.data.domainmodel.DataComponent;
import ninjabrainbot.data.domainmodel.IDataComponent;
import ninjabrainbot.data.domainmodel.IListComponent;
import ninjabrainbot.data.domainmodel.ListComponent;
import ninjabrainbot.event.IObservable;
import ninjabrainbot.event.ObservableField;

public class PreviewDataState implements IDataState {

	private final IBoatDataState boatDataState;
	private final IAllAdvancementsDataState allAdvancementsDataState;

	private final DivineContext divineContext;
	private final ListComponent<IEnderEyeThrow> throwSet;
	private final DataComponent<Boolean> locked;
	private final DataComponent<IPlayerPosition> playerPosition;

	private final ObservableField<ResultType> resultType;
	private final ObservableField<ICalculatorResult> calculatorResult;
	private final ObservableField<ChunkPrediction> topPrediction;
	private final ObservableField<BlindResult> blindResult;
	private final ObservableField<DivineResult> divineResult;

	public PreviewDataState(ICalculatorResult result, List<IEnderEyeThrow> eyeThrows, Fossil f) {
		this();
		calculatorResult.set(result);
		topPrediction.set(result.getBestPrediction());
		for (IEnderEyeThrow t : eyeThrows) {
			throwSet.add(t);
		}
		divineContext.fossil.set(f);
	}

	public PreviewDataState() {
		divineContext = new DivineContext(null);
		throwSet = new ListComponent<>(null, 10);
		playerPosition = new DataComponent<>(null);
		locked = new DataComponent<>(null, false);
		resultType = new ObservableField<>(ResultType.NONE);
		calculatorResult = new ObservableField<>();
		topPrediction = new ObservableField<>();
		blindResult = new ObservableField<>();
		divineResult = new ObservableField<>();

		boatDataState = new BoatDataState(null);
		allAdvancementsDataState = new AllAdvancementsDataState(topPrediction, null);
	}

	@Override
	public IDivineContext getDivineContext() {
		return divineContext;
	}

	@Override
	public IListComponent<IEnderEyeThrow> getThrowSet() {
		return throwSet;
	}

	@Override
	public IDataComponent<IPlayerPosition> playerPosition() {
		return playerPosition;
	}

	@Override
	public IDataComponent<Boolean> locked() {
		return locked;
	}

	@Override
	public IObservable<ICalculatorResult> calculatorResult() {
		return calculatorResult;
	}

	@Override
	public IObservable<ChunkPrediction> topPrediction() {
		return topPrediction;
	}

	@Override
	public IObservable<BlindResult> blindResult() {
		return blindResult;
	}

	@Override
	public IObservable<DivineResult> divineResult() {
		return divineResult;
	}

	@Override
	public IObservable<ResultType> resultType() {
		return resultType;

	}

	@Override
	public IAllAdvancementsDataState allAdvancementsDataState() {
		return allAdvancementsDataState;
	}

	@Override
	public IBoatDataState boatDataState() {
		return boatDataState;
	}

}
